package academico;

/**
* academico/AlunoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 22h14min40s BRST
*/

public final class AlunoHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.Aluno value = null;

  public AlunoHolder ()
  {
  }

  public AlunoHolder (academico.Aluno initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.AlunoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.AlunoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.AlunoHelper.type ();
  }

}
