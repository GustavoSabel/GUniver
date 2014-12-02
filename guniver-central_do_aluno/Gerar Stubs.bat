set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\src
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

cd %caminhoCentraAluno%
set classpath=.;%caminhoModelo%
apt br\furb\guniver\webservice\CentralAluno.java

cd..
cd bin
start java br.furb.guniver.webservice.PublicaService

cd..
cd src
wsimport -keep -p br.furb.guniver.cliente.stubs http://localhost:8080/centralAluno?wsdl

cmd