package br.furb.guniver.modelo.academico;

/**
* br/furb/guniver/modelo/academico/AlunoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Segunda-feira, 1 de Dezembro de 2014 22h19min19s BRST
*/

public final class AlunoHolder implements org.omg.CORBA.portable.Streamable
{
  public br.furb.guniver.modelo.academico.Aluno value = null;

  public AlunoHolder ()
  {
  }

  public AlunoHolder (br.furb.guniver.modelo.academico.Aluno initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = br.furb.guniver.modelo.academico.AlunoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    br.furb.guniver.modelo.academico.AlunoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return br.furb.guniver.modelo.academico.AlunoHelper.type ();
  }

}
