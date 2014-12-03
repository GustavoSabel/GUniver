REM Gerar stubs para todos os projetos

call ..\ConfigAmbiente.bat

set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoAcademico=%caminhoProjeto%\guniver-academico-server\src
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\src
set caminhoFinanceiro=%caminhoProjeto%\guniver-financeiro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

REM ACADEMICO
cd %caminhoAcademico%
set classpath=.
%jdk%\idlj -fall -pkgPrefix academico br.furb.guniver.modelo Academico.idl

REM CENTRAL DO ALUNO
cd %caminhoCentraAluno%
set classpath=.;%caminhoModelo%
%jdk%\apt br\furb\guniver\webservice\CentralAluno.java

cd..
cd bin
start "Servidor - Central do Aluno" %jdk%\java br.furb.guniver.webservice.PublicaService

cd..
cd src
%jdk%\wsimport -keep -p br.furb.guniver.cliente.stubs http://localhost:8080/centralAluno?wsdl

REM CADASTRO
cd %caminhoCadastro%
set classpath=.
%jdk%\rmic br.furb.guniver.rmi.AlunoServer
%jdk%\rmic br.furb.guniver.rmi.TurmaServer
%jdk%\rmic br.furb.guniver.rmi.DisciplinaServer
%jdk%\rmic br.furb.guniver.rmi.CursoServer

REM FINANCEIRO
cd %caminhoFinanceiro%
set classpath=.
%jdk%\rmic rmi_guniver.FinanceiroServer

cmd