set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver

cd %caminhoProjeto%\guniver-cadastro\bin
set classpath=.
start rmiregistry
start java rmi_guniver.InicializadorServicos

cmd