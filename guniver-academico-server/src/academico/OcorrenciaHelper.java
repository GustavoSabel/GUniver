package academico;


/**
* academico/OcorrenciaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 01h23min34s BRST
*/

abstract public class OcorrenciaHelper
{
  private static String  _id = "IDL:academico/Ocorrencia:1.0";

  public static void insert (org.omg.CORBA.Any a, academico.Ocorrencia that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static academico.Ocorrencia extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "descricao",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (academico.OcorrenciaHelper.id (), "Ocorrencia", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static academico.Ocorrencia read (org.omg.CORBA.portable.InputStream istream)
  {
    academico.Ocorrencia value = new academico.Ocorrencia ();
    value.descricao = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, academico.Ocorrencia value)
  {
    ostream.write_string (value.descricao);
  }

}
