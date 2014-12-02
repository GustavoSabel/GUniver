REM Inicializa todos os serviços

set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver
set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoAcademico=%caminhoProjeto%\guniver-academico-server\src
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\src
set caminhoFinanceiro=%caminhoProjeto%\guniver-financeiro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

REM ACADEMICO
cd %caminhoAcademico%
set classpath=.
idlj -fall -pkgPrefix academico br.furb.guniver.modelo Academico.idl

REM CENTRAL DO ALUNO
cd %caminhoCentraAluno%
set classpath=.;%caminhoModelo%
apt br\furb\guniver\webservice\CentralAluno.java

cd..
cd bin
start java br.furb.guniver.webservice.PublicaService

wsimport -keep -p pacote.cliente http://localhost:8080/centralAluno?wsdl

REM CADASTRO
cd %caminhoCadastro%
set classpath=.
rmic br.furb.guniver.rmi.AlunoServer
rmic br.furb.guniver.rmi.TurmaServer
rmic br.furb.guniver.rmi.DisciplinaServer
rmic br.furb.guniver.rmi.CursoServer

REM FINANCEIRO
cd %caminhoFinanceiro%
set classpath=.
rmic rmi_guniver.FinanceiroServer

cmd