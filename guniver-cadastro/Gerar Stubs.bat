set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver
set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

cd %caminhoCadastro%
set classpath=.;%caminhoModelo%
rmic br.furb.guniver.rmi.AlunoServer
rmic br.furb.guniver.rmi.TurmaServer
rmic br.furb.guniver.rmi.CursoServer
rmic br.furb.guniver.rmi.DisciplinaServer

cmd