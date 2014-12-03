call ..\ConfigAmbiente.bat
set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

cd %caminhoCadastro%
set classpath=.;%caminhoModelo%
rmic br.furb.guniver.rmi.AlunoServer
rmic br.furb.guniver.rmi.TurmaServer
rmic br.furb.guniver.rmi.CursoServer
rmic br.furb.guniver.rmi.DisciplinaServer

cmd