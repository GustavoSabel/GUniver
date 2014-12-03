REM Inicializa o serviço central do aluno

set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver
set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoAcademico=%caminhoProjeto%\guniver-academico-server\bin
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\bin
set caminhoFinanceiro=%caminhoProjeto%\guniver-financeiro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

set caminhoPadrao=br.furb.guniver

REM CENTRAL DO ALUNO
cd %caminhoCentraAluno%
set classpath=.;%caminhoModelo%;%caminhoCadastro%;%caminhoFinanceiro%;%caminhoProjeto%;%caminhoAcademico%
java %caminhoPadrao%.webservice.PublicaService
cmd

set classpath=%caminhoCadastro%;%caminhoFinanceiro%;%caminhoModelo%;%caminhoProjeto%;%caminhoAcademico%
start rmiregistry