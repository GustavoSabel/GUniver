package br.furb.guniver.modelo.academico;


/**
* br/furb/guniver/modelo/academico/MatriculaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 3 de Dezembro de 2014 04h32min40s BRST
*/

abstract public class MatriculaHelper
{
  private static String  _id = "IDL:academico/Matricula:1.0";

  public static void insert (org.omg.CORBA.Any a, br.furb.guniver.modelo.academico.Matricula that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static br.furb.guniver.modelo.academico.Matricula extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "codigoAluno",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "codigoTurma",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (br.furb.guniver.modelo.academico.MatriculaHelper.id (), "Matricula", _members0);
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

  public static br.furb.guniver.modelo.academico.Matricula read (org.omg.CORBA.portable.InputStream istream)
  {
    br.furb.guniver.modelo.academico.Matricula value = new br.furb.guniver.modelo.academico.Matricula ();
    value.codigoAluno = istream.read_long ();
    value.codigoTurma = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, br.furb.guniver.modelo.academico.Matricula value)
  {
    ostream.write_long (value.codigoAluno);
    ostream.write_long (value.codigoTurma);
  }

}
