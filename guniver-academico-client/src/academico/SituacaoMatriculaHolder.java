package academico;

/**
* academico/SituacaoMatriculaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 22h28min20s BRST
*/

public final class SituacaoMatriculaHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.SituacaoMatricula value = null;

  public SituacaoMatriculaHolder ()
  {
  }

  public SituacaoMatriculaHolder (academico.SituacaoMatricula initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.SituacaoMatriculaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.SituacaoMatriculaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.SituacaoMatriculaHelper.type ();
  }

}
