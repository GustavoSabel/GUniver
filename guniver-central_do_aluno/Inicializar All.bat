REM Inicializa todos os serviços

set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver

REM ACADEMICO
cd %caminhoProjeto%\guniver-academico-server\bin
set classpath=.
start orbd
start java corba_guniver.servidor

REM CENTRAL DO ALUNO
cd %caminhoProjeto%\guniver-central_do_aluno\bin"
set classpath=.
start java webservice_guniver.PublicaService

set caminhoCadastro = %caminhoProjeto%\guniver-cadastro\bin
set caminhoFinanceiro = %caminhoProjeto%\guniver-financeiro\bin
set classpath=caminhoCadastro;caminhoFinanceiro
start rmiregistry

REM CADASTRO
cd caminhoCadastro
start java rmi_guniver.InicializadorServicos

REM FINANCEIRO
cd caminhoFinanceiro
start java rmi_guniver.FinanceiroServer

cmd