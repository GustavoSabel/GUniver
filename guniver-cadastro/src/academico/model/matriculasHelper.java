package academico.model;


/**
* academico/matriculasHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 00h01min29s BRST
*/


//typedef sequence<notasAlunos> notasTurmas;
abstract public class matriculasHelper
{
  private static String  _id = "IDL:academico/matriculas:1.0";

  public static void insert (org.omg.CORBA.Any a, academico.model.Matricula[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static academico.model.Matricula[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = academico.model.MatriculaHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (academico.model.matriculasHelper.id (), "matriculas", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static academico.model.Matricula[] read (org.omg.CORBA.portable.InputStream istream)
  {
    academico.model.Matricula value[] = null;
    int _len0 = istream.read_long ();
    value = new academico.model.Matricula[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = academico.model.MatriculaHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, academico.model.Matricula[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      academico.model.MatriculaHelper.write (ostream, value[_i0]);
  }

}
