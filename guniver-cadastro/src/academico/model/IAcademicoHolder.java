package academico.model;

/**
* academico/IAcademicoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 00h01min29s BRST
*/


//enum SituacaoMatricula { pago, atrazado, a_pagar };
public final class IAcademicoHolder implements org.omg.CORBA.portable.Streamable
{
  public academico.model.IAcademico value = null;

  public IAcademicoHolder ()
  {
  }

  public IAcademicoHolder (academico.model.IAcademico initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = academico.model.IAcademicoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    academico.model.IAcademicoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return academico.model.IAcademicoHelper.type ();
  }

}
