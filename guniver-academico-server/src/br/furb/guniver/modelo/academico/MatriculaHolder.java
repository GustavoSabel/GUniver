package br.furb.guniver.modelo.academico;

/**
* br/furb/guniver/modelo/academico/MatriculaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 3 de Dezembro de 2014 04h32min40s BRST
*/

public final class MatriculaHolder implements org.omg.CORBA.portable.Streamable
{
  public br.furb.guniver.modelo.academico.Matricula value = null;

  public MatriculaHolder ()
  {
  }

  public MatriculaHolder (br.furb.guniver.modelo.academico.Matricula initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = br.furb.guniver.modelo.academico.MatriculaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    br.furb.guniver.modelo.academico.MatriculaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return br.furb.guniver.modelo.academico.MatriculaHelper.type ();
  }

}
