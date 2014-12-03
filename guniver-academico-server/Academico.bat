set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver

cd %caminhoProjeto%\guniver-academico-server\bin
set classpath=.
start orbd
start java br.furb.guniver.corba.servidor

cmd