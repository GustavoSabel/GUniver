package br.furb.guniver.modelo.academico;


/**
* br/furb/guniver/modelo/academico/provasHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Segunda-feira, 1 de Dezembro de 2014 23h11min42s BRST
*/

public final class provasHolder implements org.omg.CORBA.portable.Streamable
{
  public br.furb.guniver.modelo.academico.Prova value[] = null;

  public provasHolder ()
  {
  }

  public provasHolder (br.furb.guniver.modelo.academico.Prova[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = br.furb.guniver.modelo.academico.provasHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    br.furb.guniver.modelo.academico.provasHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return br.furb.guniver.modelo.academico.provasHelper.type ();
  }

}
