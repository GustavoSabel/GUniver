REM Inicializa todos os serviços

set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver
set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoAcademico=%caminhoProjeto%\guniver-academico-server\bin
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\bin
set caminhoFinanceiro=%caminhoProjeto%\guniver-financeiro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

set caminhoPadrao=br.furb.guniver

REM ACADEMICO
cd %caminhoAcademico%
set classpath=.
start orbd
start java %caminhoPadrao%.corba.servidor


REM CENTRAL DO ALUNO
cd %caminhoCentraAluno%
set classpath=.;%caminhoModelo%;%caminhoCadastro%;%caminhoFinanceiro%;%caminhoProjeto%;%caminhoAcademico%
start java %caminhoPadrao%.webservice.PublicaService


set classpath=%caminhoCadastro%;%caminhoFinanceiro%;%caminhoModelo%;%caminhoProjeto%;%caminhoAcademico%
start rmiregistry

REM CADASTRO
cd %caminhoCadastro%
set classpath=.;%caminhoModelo%;%caminhoProjeto%;%caminhoAcademico%
start java %caminhoPadrao%.rmi.InicializadorServicos


REM FINANCEIRO
cd %caminhoFinanceiro%
set classpath=.;%caminhoModelo%
start java rmi_guniver.FinanceiroServer