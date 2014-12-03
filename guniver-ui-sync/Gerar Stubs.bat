set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
cd src

wsimport -keep -p br.furb.guniver.central_do_aluno.stubs http://localhost:8080/centralAluno?wsdl

cmd