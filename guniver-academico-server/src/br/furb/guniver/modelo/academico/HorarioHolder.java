package br.furb.guniver.modelo.academico;

/**
* br/furb/guniver/modelo/academico/HorarioHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Segunda-feira, 1 de Dezembro de 2014 23h11min42s BRST
*/

public final class HorarioHolder implements org.omg.CORBA.portable.Streamable
{
  public br.furb.guniver.modelo.academico.Horario value = null;

  public HorarioHolder ()
  {
  }

  public HorarioHolder (br.furb.guniver.modelo.academico.Horario initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = br.furb.guniver.modelo.academico.HorarioHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    br.furb.guniver.modelo.academico.HorarioHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return br.furb.guniver.modelo.academico.HorarioHelper.type ();
  }

}
