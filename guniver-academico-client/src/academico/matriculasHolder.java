package academico;


/**
* academico/matriculasHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 00h01min29s BRST
*/


//typedef sequence<notasAlunos> notasTurmas;
public final class matriculasHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.Matricula value[] = null;

  public matriculasHolder ()
  {
  }

  public matriculasHolder (academico.Matricula[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.matriculasHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.matriculasHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.matriculasHelper.type ();
  }

}
