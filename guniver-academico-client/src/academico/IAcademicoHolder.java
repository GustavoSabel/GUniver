package academico;

/**
* academico/IAcademicoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 22h14min40s BRST
*/

public final class IAcademicoHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.IAcademico value = null;

  public IAcademicoHolder ()
  {
  }

  public IAcademicoHolder (academico.IAcademico initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.IAcademicoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.IAcademicoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.IAcademicoHelper.type ();
  }

}