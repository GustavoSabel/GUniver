set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver
set caminhoUiSync=%caminhoProjeto%\guniver-ui-sync\src

cd %caminhoUiSync%
set classpath=.;%caminhoModelo%

wsimport -keep -p br.furb.guniver.central_do_aluno.stubs http://localhost:8080/centralAluno?wsdl

cmd