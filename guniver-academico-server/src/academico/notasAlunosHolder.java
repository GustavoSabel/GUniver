package academico;


/**
* academico/notasAlunosHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 21h55min02s BRST
*/

public final class notasAlunosHolder implements org.omg.CORBA.portable.Streamable
{
  public float value[] = null;

  public notasAlunosHolder ()
  {
  }

  public notasAlunosHolder (float[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.notasAlunosHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.notasAlunosHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.notasAlunosHelper.type ();
  }

}
