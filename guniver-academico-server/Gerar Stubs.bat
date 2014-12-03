set path=%path%;"C:\Program Files\Java\jdk1.7.0_71\bin"
set caminhoProjeto=C:\Users\Gustavo\git\GUniver
set caminhoCadastro=%caminhoProjeto%\guniver-cadastro\bin
set caminhoAcademico=%caminhoProjeto%\guniver-academico-server\src
set caminhoCentraAluno=%caminhoProjeto%\guniver-central_do_aluno\src
set caminhoFinanceiro=%caminhoProjeto%\guniver-financeiro\bin
set caminhoModelo=%caminhoProjeto%\guniver-modelo\bin

REM ACADEMICO
cd %caminhoAcademico%
set classpath=.
idlj -fall -pkgPrefix academico br.furb.guniver.modelo Academico.idl

cmd