cd C:\Users\Gustavo\git\GUniver\guniver-central_do_aluno\src
set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
apt webservice_guniver\CentralAluno.java

cd C:\Users\Gustavo\git\GUniver\guniver-central_do_aluno\bin
set classpath=.;C:\Users\Gustavo\Documents\Eclipse\guniver-modelo\bin
start java webservice_guniver.PublicaService

cd C:\Users\Gustavo\git\GUniver\guniver-central_do_aluno\src
wsimport -keep -p pacote.cliente http://localhost:8080/criarCompromisso?wsdl
wsimport -keep -p pacote.cliente http://localhost:8080/removerCompromisso?wsdl
wsimport -keep -p pacote.cliente http://localhost:8080/getCompromissos?wsdl
wsimport -keep -p pacote.cliente http://localhost:8080/getCompromissosAluno?wsdl
wsimport -keep -p pacote.cliente http://localhost:8080/getMaterial?wsdl
wsimport -keep -p pacote.cliente http://localhost:8080/getProvas?wsdl
wsimport -keep -p pacote.cliente http://localhost:8080/getMatriculasAluno?wsdl
wsimport -keep -p pacote.cliente http://localhost:8080/getMatriculasTurma?wsdl
wsimport -keep -p pacote.cliente http://localhost:8080/getHorarios?wsdl