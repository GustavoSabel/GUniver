package academico;

/**
* academico/ProvaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Domingo, 30 de Novembro de 2014 22h44min29s BRST
*/

public final class ProvaHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.Prova value = null;

  public ProvaHolder ()
  {
  }

  public ProvaHolder (academico.Prova initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.ProvaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.ProvaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.ProvaHelper.type ();
  }

}
