REM Inicializa todos os serviços

call ..\ConfigAmbiente.bat

set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoAcademico=%caminhoProjeto%\guniver-academico-server\bin
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\bin
set caminhoFinanceiro=%caminhoProjeto%\guniver-financeiro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

set caminhoPadrao=br.furb.guniver

REM ACADEMICO
cd %caminhoAcademico%
set classpath=.
start "ORBD" %jdk%\orbd
start "Servidor - Academico" %jdk%\java %caminhoPadrao%.corba.servidor


REM CENTRAL DO ALUNO
cd %caminhoCentraAluno%
set classpath=.;%caminhoModelo%;%caminhoCadastro%;%caminhoFinanceiro%;%caminhoProjeto%;%caminhoAcademico%
start "Servidor - Central do Aluno" %jdk%\java %caminhoPadrao%.webservice.PublicaService


set classpath=%caminhoCadastro%;%caminhoFinanceiro%;%caminhoModelo%;%caminhoProjeto%;%caminhoAcademico%
start "rmiregistry" %jdk%\rmiregistry

REM CADASTRO
cd %caminhoCadastro%
set classpath=.;%caminhoModelo%;%caminhoProjeto%;%caminhoAcademico%
start "Servidor - Cadastro" %jdk%\java %caminhoPadrao%.rmi.InicializadorServicos


REM FINANCEIRO
cd %caminhoFinanceiro%
set classpath=.;%caminhoModelo%
start "Servidor - Financeiro" %jdk%\java %caminhoPadrao%.rmi.FinanceiroServer