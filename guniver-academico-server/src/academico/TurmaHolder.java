package academico;

/**
* academico/TurmaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 21h55min02s BRST
*/

public final class TurmaHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.Turma value = null;

  public TurmaHolder ()
  {
  }

  public TurmaHolder (academico.Turma initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.TurmaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.TurmaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.TurmaHelper.type ();
  }

}
