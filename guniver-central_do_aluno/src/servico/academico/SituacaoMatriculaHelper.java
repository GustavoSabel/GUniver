package servico.academico;


/**
* academico/SituacaoMatriculaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 22h28min20s BRST
*/

abstract public class SituacaoMatriculaHelper
{
  private static String  _id = "IDL:academico/SituacaoMatricula:1.0";

  public static void insert (org.omg.CORBA.Any a, servico.academico.SituacaoMatricula that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static servico.academico.SituacaoMatricula extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (servico.academico.SituacaoMatriculaHelper.id (), "SituacaoMatricula", new String[] { "pago", "atrazado", "a_pagar"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static servico.academico.SituacaoMatricula read (org.omg.CORBA.portable.InputStream istream)
  {
    return servico.academico.SituacaoMatricula.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, servico.academico.SituacaoMatricula value)
  {
    ostream.write_long (value.value ());
  }

}
