call ..\ConfigAmbiente.bat

cd %caminhoProjeto%\guniver-academico-server\bin
set classpath=.
start "ORBD" %jdk%\orbd
start "Servidor - Academico" %jdk%\java br.furb.guniver.corba.servidor

cmd
