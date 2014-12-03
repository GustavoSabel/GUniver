call ..\ConfigAmbiente.bat

cd %caminhoProjeto%\guniver-financeiro\bin
set classpath=.
start "rmiregistry" %jdk%\rmiregistry
start "Servidor - Financeiro" %jdk%\java rmi_guniver.FinanceiroServer

cmd