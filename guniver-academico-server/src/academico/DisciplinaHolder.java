package academico;

/**
* academico/DisciplinaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 01h23min34s BRST
*/

public final class DisciplinaHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.Disciplina value = null;

  public DisciplinaHolder ()
  {
  }

  public DisciplinaHolder (academico.Disciplina initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.DisciplinaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.DisciplinaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.DisciplinaHelper.type ();
  }

}