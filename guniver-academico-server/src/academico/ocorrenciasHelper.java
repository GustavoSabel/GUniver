package academico;


/**
* academico/ocorrenciasHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Domingo, 16 de Novembro de 2014 22h50min10s BRST
*/

abstract public class ocorrenciasHelper
{
  private static String  _id = "IDL:academico/ocorrencias:1.0";

  public static void insert (org.omg.CORBA.Any a, academico.Ocorrencia[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static academico.Ocorrencia[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = academico.OcorrenciaHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (academico.ocorrenciasHelper.id (), "ocorrencias", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static academico.Ocorrencia[] read (org.omg.CORBA.portable.InputStream istream)
  {
    academico.Ocorrencia value[] = null;
    int _len0 = istream.read_long ();
    value = new academico.Ocorrencia[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = academico.OcorrenciaHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, academico.Ocorrencia[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      academico.OcorrenciaHelper.write (ostream, value[_i0]);
  }

}
