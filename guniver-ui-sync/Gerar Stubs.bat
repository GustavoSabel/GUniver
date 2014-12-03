set path=%path%;"C:\Program Files\Java\jdk1.7.0_06\bin"
set caminhoProjeto=C:\Users\Vivian\git\GUniver
set caminhoUiSync=%caminhoProjeto%\guniver-ui-sync\src

cd %caminhoUiSync%

wsimport -keep -p br.furb.guniver.central_do_aluno.stubs http://192.168.0.13:8080/centralAluno?wsdl

cmd