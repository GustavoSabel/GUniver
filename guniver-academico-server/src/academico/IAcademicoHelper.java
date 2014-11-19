package academico;


/**
* academico/IAcademicoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 01h23min34s BRST
*/

abstract public class IAcademicoHelper
{
  private static String  _id = "IDL:academico/IAcademico:1.0";

  public static void insert (org.omg.CORBA.Any a, academico.IAcademico that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static academico.IAcademico extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (academico.IAcademicoHelper.id (), "IAcademico");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static academico.IAcademico read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_IAcademicoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, academico.IAcademico value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static academico.IAcademico narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof academico.IAcademico)
      return (academico.IAcademico)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      academico._IAcademicoStub stub = new academico._IAcademicoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static academico.IAcademico unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof academico.IAcademico)
      return (academico.IAcademico)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      academico._IAcademicoStub stub = new academico._IAcademicoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
