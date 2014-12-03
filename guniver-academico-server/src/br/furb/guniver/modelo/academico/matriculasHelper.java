package br.furb.guniver.modelo.academico;


/**
* br/furb/guniver/modelo/academico/matriculasHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 3 de Dezembro de 2014 04h32min40s BRST
*/


//typedef sequence<notasAlunos> notasTurmas;
abstract public class matriculasHelper
{
  private static String  _id = "IDL:academico/matriculas:1.0";

  public static void insert (org.omg.CORBA.Any a, br.furb.guniver.modelo.academico.Matricula[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static br.furb.guniver.modelo.academico.Matricula[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = br.furb.guniver.modelo.academico.MatriculaHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (br.furb.guniver.modelo.academico.matriculasHelper.id (), "matriculas", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static br.furb.guniver.modelo.academico.Matricula[] read (org.omg.CORBA.portable.InputStream istream)
  {
    br.furb.guniver.modelo.academico.Matricula value[] = null;
    int _len0 = istream.read_long ();
    value = new br.furb.guniver.modelo.academico.Matricula[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = br.furb.guniver.modelo.academico.MatriculaHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, br.furb.guniver.modelo.academico.Matricula[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      br.furb.guniver.modelo.academico.MatriculaHelper.write (ostream, value[_i0]);
  }

}
