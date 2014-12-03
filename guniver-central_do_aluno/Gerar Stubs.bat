set path=%path%;"C:\Program Files\Java\jdk1.7.0_06\bin"
set caminhoProjeto=C:\Users\Vivian\git\GUniver
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\src

cd %caminhoCentraAluno%

wsimport -keep -p br.furb.guniver.cliente.stubs http://192.168.0.13:8080/centralAluno?wsdl

cmd