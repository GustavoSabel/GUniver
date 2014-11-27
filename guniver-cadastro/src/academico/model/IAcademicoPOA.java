package academico.model;


/**
* academico/IAcademicoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 00h01min29s BRST
*/


//enum SituacaoMatricula { pago, atrazado, a_pagar };
public abstract class IAcademicoPOA extends org.omg.PortableServer.Servant
 implements academico.model.IAcademicoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getNotasAluno", new java.lang.Integer (0));
    _methods.put ("getMatricula", new java.lang.Integer (1));
    _methods.put ("getMatriculas", new java.lang.Integer (2));
    _methods.put ("getMatriculasSemestre", new java.lang.Integer (3));
    _methods.put ("matricular", new java.lang.Integer (4));
    _methods.put ("getHorarios", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // academico/IAcademico/getNotasAluno
       {
         academico.model.Aluno aluno = academico.model.AlunoHelper.read (in);
         academico.model.Turma turma = academico.model.TurmaHelper.read (in);
         float $result[] = null;
         $result = this.getNotasAluno (aluno, turma);
         out = $rh.createReply();
         academico.model.notasAlunosHelper.write (out, $result);
         break;
       }

       case 1:  // academico/IAcademico/getMatricula
       {
         academico.model.Aluno aluno = academico.model.AlunoHelper.read (in);
         academico.model.Disciplina disciplina = academico.model.DisciplinaHelper.read (in);
         academico.model.Matricula $result = null;
         $result = this.getMatricula (aluno, disciplina);
         out = $rh.createReply();
         academico.model.MatriculaHelper.write (out, $result);
         break;
       }

       case 2:  // academico/IAcademico/getMatriculas
       {
         academico.model.Aluno aluno = academico.model.AlunoHelper.read (in);
         academico.model.Matricula $result[] = null;
         $result = this.getMatriculas (aluno);
         out = $rh.createReply();
         academico.model.matriculasHelper.write (out, $result);
         break;
       }

       case 3:  // academico/IAcademico/getMatriculasSemestre
       {
         academico.model.Aluno aluno = academico.model.AlunoHelper.read (in);
         short ano = in.read_short ();
         short semestre = in.read_short ();
         academico.model.Matricula $result[] = null;
         $result = this.getMatriculasSemestre (aluno, ano, semestre);
         out = $rh.createReply();
         academico.model.matriculasHelper.write (out, $result);
         break;
       }

       case 4:  // academico/IAcademico/matricular
       {
         academico.model.Aluno aluno = academico.model.AlunoHelper.read (in);
         academico.model.Turma turma = academico.model.TurmaHelper.read (in);
         org.omg.CORBA.StringHolder mensagemErro = new org.omg.CORBA.StringHolder ();
         boolean $result = false;
         $result = this.matricular (aluno, turma, mensagemErro);
         out = $rh.createReply();
         out.write_boolean ($result);
         out.write_string (mensagemErro.value);
         break;
       }

       case 5:  // academico/IAcademico/getHorarios
       {
         academico.model.Horario $result[] = null;
         $result = this.getHorarios ();
         out = $rh.createReply();
         academico.model.horariosHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:academico/IAcademico:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public IAcademico _this() 
  {
    return IAcademicoHelper.narrow(
    super._this_object());
  }

  public IAcademico _this(org.omg.CORBA.ORB orb) 
  {
    return IAcademicoHelper.narrow(
    super._this_object(orb));
  }


} // class IAcademicoPOA
