package academico;


/**
* academico/MatriculaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 22h14min40s BRST
*/

abstract public class MatriculaHelper
{
  private static String  _id = "IDL:academico/Matricula:1.0";

  public static void insert (org.omg.CORBA.Any a, academico.Matricula that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static academico.Matricula extract (org.omg.CORBA.Any a)
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
          _tcOf_members0 = academico.AlunoHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "aluno",
            _tcOf_members0,
            null);
          _tcOf_members0 = academico.TurmaHelper.type ();
          _members0[1] = new org.omg.CORBA.StructMember (
            "turma",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (academico.MatriculaHelper.id (), "Matricula", _members0);
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

  public static academico.Matricula read (org.omg.CORBA.portable.InputStream istream)
  {
    academico.Matricula value = new academico.Matricula ();
    value.aluno = academico.AlunoHelper.read (istream);
    value.turma = academico.TurmaHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, academico.Matricula value)
  {
    academico.AlunoHelper.write (ostream, value.aluno);
    academico.TurmaHelper.write (ostream, value.turma);
  }

}