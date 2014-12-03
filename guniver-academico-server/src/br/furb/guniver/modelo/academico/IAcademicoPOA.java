package br.furb.guniver.modelo.academico;


/**
* br/furb/guniver/modelo/academico/IAcademicoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 3 de Dezembro de 2014 03h40min06s BRST
*/


//enum SituacaoMatricula { pago, atrazado, a_pagar };
public abstract class IAcademicoPOA extends org.omg.PortableServer.Servant
 implements br.furb.guniver.modelo.academico.IAcademicoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getProvasAluno", new java.lang.Integer (0));
    _methods.put ("getProvas", new java.lang.Integer (1));
    _methods.put ("getMatricula", new java.lang.Integer (2));
    _methods.put ("getMatriculasAluno", new java.lang.Integer (3));
    _methods.put ("getMatriculasTurma", new java.lang.Integer (4));
    _methods.put ("cadastrarMatricula", new java.lang.Integer (5));
    _methods.put ("getHorarios", new java.lang.Integer (6));
    _methods.put ("cadastrarProva", new java.lang.Integer (7));
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
       case 0:  // academico/IAcademico/getProvasAluno
       {
         int codigoAluno = in.read_long ();
         int codigoTurma = in.read_long ();
         br.furb.guniver.modelo.academico.Prova $result[] = null;
         $result = this.getProvasAluno (codigoAluno, codigoTurma);
         out = $rh.createReply();
         br.furb.guniver.modelo.academico.provasHelper.write (out, $result);
         break;
       }

       case 1:  // academico/IAcademico/getProvas
       {
         br.furb.guniver.modelo.academico.Prova $result[] = null;
         $result = this.getProvas ();
         out = $rh.createReply();
         br.furb.guniver.modelo.academico.provasHelper.write (out, $result);
         break;
       }

       case 2:  // academico/IAcademico/getMatricula
       {
         int codigoAluno = in.read_long ();
         int codigoDisciplina = in.read_long ();
         br.furb.guniver.modelo.academico.Matricula $result = null;
         $result = this.getMatricula (codigoAluno, codigoDisciplina);
         out = $rh.createReply();
         br.furb.guniver.modelo.academico.MatriculaHelper.write (out, $result);
         break;
       }

       case 3:  // academico/IAcademico/getMatriculasAluno
       {
         int codigoAluno = in.read_long ();
         br.furb.guniver.modelo.academico.Matricula $result[] = null;
         $result = this.getMatriculasAluno (codigoAluno);
         out = $rh.createReply();
         br.furb.guniver.modelo.academico.matriculasHelper.write (out, $result);
         break;
       }

       case 4:  // academico/IAcademico/getMatriculasTurma
       {
         int codigoTurma = in.read_long ();
         br.furb.guniver.modelo.academico.Matricula $result[] = null;
         $result = this.getMatriculasTurma (codigoTurma);
         out = $rh.createReply();
         br.furb.guniver.modelo.academico.matriculasHelper.write (out, $result);
         break;
       }


  //matriculas getMatriculasSemestre(in long codigoAluno, in short ano, in short semestre);
       case 5:  // academico/IAcademico/cadastrarMatricula
       {
         int codigoAluno = in.read_long ();
         int codigoTurma = in.read_long ();
         org.omg.CORBA.StringHolder mensagemErro = new org.omg.CORBA.StringHolder ();
         boolean $result = false;
         $result = this.cadastrarMatricula (codigoAluno, codigoTurma, mensagemErro);
         out = $rh.createReply();
         out.write_boolean ($result);
         out.write_string (mensagemErro.value);
         break;
       }

       case 6:  // academico/IAcademico/getHorarios
       {
         int codigoTurma = in.read_long ();
         br.furb.guniver.modelo.academico.Horario $result[] = null;
         $result = this.getHorarios (codigoTurma);
         out = $rh.createReply();
         br.furb.guniver.modelo.academico.horariosHelper.write (out, $result);
         break;
       }


  //boolean cadastrarDisciplina(in Disciplina disciplina, out string mensagemErro);
       case 7:  // academico/IAcademico/cadastrarProva
       {
         br.furb.guniver.modelo.academico.Prova prova = br.furb.guniver.modelo.academico.ProvaHelper.read (in);
         org.omg.CORBA.StringHolder mensagemErro = new org.omg.CORBA.StringHolder ();
         boolean $result = false;
         $result = this.cadastrarProva (prova, mensagemErro);
         out = $rh.createReply();
         out.write_boolean ($result);
         out.write_string (mensagemErro.value);
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
