call ..\ConfigAmbiente.bat

set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\src
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

cd %caminhoCentraAluno%
set classpath=.;%caminhoModelo%
%jdk%\apt br\furb\guniver\webservice\CentralAluno.java

cd..
cd bin
start "Servidor - Central do Aluno" %jdk%\java br.furb.guniver.webservice.PublicaService

cd..
cd src
%jdk%\wsimport -keep -p br.furb.guniver.cliente.stubs http://localhost:8080/centralAluno?wsdl

cmd