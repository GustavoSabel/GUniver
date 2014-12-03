package br.furb.guniver.modelo.academico;


/**
* br/furb/guniver/modelo/academico/_IAcademicoStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 3 de Dezembro de 2014 04h32min40s BRST
*/


//enum SituacaoMatricula { pago, atrazado, a_pagar };
public class _IAcademicoStub extends org.omg.CORBA.portable.ObjectImpl implements br.furb.guniver.modelo.academico.IAcademico
{

  public br.furb.guniver.modelo.academico.Prova[] getProvasAluno (int codigoAluno, int codigoTurma)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getProvasAluno", true);
                $out.write_long (codigoAluno);
                $out.write_long (codigoTurma);
                $in = _invoke ($out);
                br.furb.guniver.modelo.academico.Prova $result[] = br.furb.guniver.modelo.academico.provasHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getProvasAluno (codigoAluno, codigoTurma        );
            } finally {
                _releaseReply ($in);
            }
  } // getProvasAluno

  public br.furb.guniver.modelo.academico.Prova[] getProvas ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getProvas", true);
                $in = _invoke ($out);
                br.furb.guniver.modelo.academico.Prova $result[] = br.furb.guniver.modelo.academico.provasHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getProvas (        );
            } finally {
                _releaseReply ($in);
            }
  } // getProvas

  public br.furb.guniver.modelo.academico.Matricula[] getMatriculasAluno (int codigoAluno)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getMatriculasAluno", true);
                $out.write_long (codigoAluno);
                $in = _invoke ($out);
                br.furb.guniver.modelo.academico.Matricula $result[] = br.furb.guniver.modelo.academico.matriculasHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getMatriculasAluno (codigoAluno        );
            } finally {
                _releaseReply ($in);
            }
  } // getMatriculasAluno

  public br.furb.guniver.modelo.academico.Matricula[] getMatriculasTurma (int codigoTurma)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getMatriculasTurma", true);
                $out.write_long (codigoTurma);
                $in = _invoke ($out);
                br.furb.guniver.modelo.academico.Matricula $result[] = br.furb.guniver.modelo.academico.matriculasHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getMatriculasTurma (codigoTurma        );
            } finally {
                _releaseReply ($in);
            }
  } // getMatriculasTurma


  //matriculas getMatriculasSemestre(in long codigoAluno, in short ano, in short semestre);
  public boolean cadastrarMatricula (int codigoAluno, int codigoTurma, org.omg.CORBA.StringHolder mensagemErro)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("cadastrarMatricula", true);
                $out.write_long (codigoAluno);
                $out.write_long (codigoTurma);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                mensagemErro.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return cadastrarMatricula (codigoAluno, codigoTurma, mensagemErro        );
            } finally {
                _releaseReply ($in);
            }
  } // cadastrarMatricula

  public br.furb.guniver.modelo.academico.Horario[] getHorarios (int codigoTurma)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getHorarios", true);
                $out.write_long (codigoTurma);
                $in = _invoke ($out);
                br.furb.guniver.modelo.academico.Horario $result[] = br.furb.guniver.modelo.academico.horariosHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getHorarios (codigoTurma        );
            } finally {
                _releaseReply ($in);
            }
  } // getHorarios


  //boolean cadastrarDisciplina(in Disciplina disciplina, out string mensagemErro);
  public boolean cadastrarProva (br.furb.guniver.modelo.academico.Prova prova, org.omg.CORBA.StringHolder mensagemErro)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("cadastrarProva", true);
                br.furb.guniver.modelo.academico.ProvaHelper.write ($out, prova);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                mensagemErro.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return cadastrarProva (prova, mensagemErro        );
            } finally {
                _releaseReply ($in);
            }
  } // cadastrarProva

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:academico/IAcademico:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _IAcademicoStub
