package br.furb.guniver.sync;

import java.net.URL;
import java.rmi.Naming;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ThreadPoolExecutor;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import br.furb.guniver.central_do_aluno.stubs.CentralAluno;
import br.furb.guniver.central_do_aluno.stubs.CentralAlunoService;
import br.furb.guniver.central_do_aluno.stubs.Prova;
import br.furb.guniver.modelo.academico.IAcademico;
import br.furb.guniver.modelo.academico.IAcademicoHelper;
import br.furb.guniver.rmi.AlunoRemote;
import br.furb.guniver.utils.ConversorAcademico;

public class ProvasSynchronizer extends EntitiesSynchronizer<Prova> {

    private CentralAluno centralAluno;
    private String moduleUrl;

    public ProvasSynchronizer(String moduleUrl, ThreadPoolExecutor executor) {
	super(moduleUrl, executor);
	try {
	    URL url = new URL("http://" + moduleUrl + ":8080/centralAluno");
	    centralAluno = new CentralAlunoService(url).getCentralAlunoPort();

	    this.moduleUrl = moduleUrl;
	} catch (Exception ex) {
	    throw new RuntimeException("Erro ao conectar com " + moduleUrl, ex);
	}
    }

    private IAcademico getAcademico() {
	try {
	    String[] args = new String[] { "-ORBInitialHost", this.moduleUrl };
	    ORB orb = ORB.init(args, null);

	    org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	    NamingContextExt namecontextRef = NamingContextExtHelper.narrow(objRef);

	    IAcademico academico = IAcademicoHelper.narrow(namecontextRef.resolve_str("IAcademico"));
	    return academico;

	} catch (InvalidName | NotFound | org.omg.CORBA.ORBPackage.InvalidName | CannotProceed e) {
	    throw new RuntimeException("Erro no módulo CADASTRO ao consultar o móduclo ACADEMICO", e);
	}
    }

    @Override
    protected void doDownload(Prova entityAccessor) {
	// TODO Auto-generated method stub
    }

    @Override
    protected Collection<Prova> doDownloadAll() {
	try {
	    return centralAluno.getProvas();
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    @Override
    protected void doUpload(Prova entity) {
	StringHolder mensagemErro = new StringHolder();
	if (!getAcademico().cadastrarProva(ConversorAcademico.cast(entity), mensagemErro)) {
	    throw new RuntimeException(mensagemErro.value);
	}
    }

    @Override
    protected void doUploadAll(Collection<Prova> entities) {
	StringHolder mensagemErro = new StringHolder();
	for (Prova entity : entities) {
	    if (!getAcademico().cadastrarProva(ConversorAcademico.cast(entity), mensagemErro)) {
		throw new RuntimeException(mensagemErro.value);
	    }
	}
    }

}
