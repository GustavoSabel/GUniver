set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\src

cd %caminhoCentraAluno%
set classpath=.
apt br\furb\guniver\webservice_guniver\CentralAluno.java

cd..
cd bin
start java br.furb.guniver.webservice_guniver.PublicaService

wsimport -keep -p pacote.cliente http://localhost:8080/centralAluno?wsdl