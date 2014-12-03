REM Inicializa o serviço central do aluno

call ..\ConfigAmbiente.bat

set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoAcademico=%caminhoProjeto%\guniver-academico-server\bin
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\bin
set caminhoFinanceiro=%caminhoProjeto%\guniver-financeiro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

set caminhoPadrao=br.furb.guniver

REM CENTRAL DO ALUNO
cd %caminhoCentraAluno%

set classpath=.;%caminhoCadastro%;%caminhoFinanceiro%;%caminhoModelo%;%caminhoProjeto%;%caminhoAcademico%
start "rmiregistry" %jdk%\rmiregistry

set classpath=.;%caminhoModelo%;%caminhoCadastro%;%caminhoFinanceiro%;%caminhoProjeto%;%caminhoAcademico%
start "Servidor - Central do Aluno" %jdk%\java %caminhoPadrao%.webservice.PublicaService
