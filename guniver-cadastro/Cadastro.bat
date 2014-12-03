call ..\ConfigAmbiente.bat
set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

cd %caminhoCadastro%
set classpath=.;%caminhoModelo%
start "rmiregistry" %jdk%\rmiregistry
start "Servidor - Cadastro" %jdk%\java br.furb.guniver.rmi.InicializadorServicos

cmd