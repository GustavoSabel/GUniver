package academico;


/**
* academico/horariosHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 21h55min02s BRST
*/

public final class horariosHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.Horario value[] = null;

  public horariosHolder ()
  {
  }

  public horariosHolder (academico.Horario[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.horariosHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.horariosHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.horariosHelper.type ();
  }

}
