package academico;

/**
* academico/MatriculaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Domingo, 30 de Novembro de 2014 22h44min29s BRST
*/

public final class MatriculaHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.Matricula value = null;

  public MatriculaHolder ()
  {
  }

  public MatriculaHolder (academico.Matricula initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.MatriculaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.MatriculaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.MatriculaHelper.type ();
  }

}
