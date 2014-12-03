call ..\ConfigAmbiente.bat
set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

cd %caminhoCadastro%
set classpath=.;%caminhoModelo%
%jdk%\rmic br.furb.guniver.rmi.AlunoServer
%jdk%\rmic br.furb.guniver.rmi.TurmaServer
%jdk%\rmic br.furb.guniver.rmi.CursoServer
%jdk%\rmic br.furb.guniver.rmi.DisciplinaServer

cmd