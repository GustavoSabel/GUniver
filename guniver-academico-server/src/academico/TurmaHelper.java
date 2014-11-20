package academico;


/**
* academico/TurmaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 22h28min20s BRST
*/

abstract public class TurmaHelper
{
  private static String  _id = "IDL:academico/Turma:1.0";

  public static void insert (org.omg.CORBA.Any a, academico.Turma that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static academico.Turma extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [5];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "codigo",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "nome",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[2] = new org.omg.CORBA.StructMember (
            "ano",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[3] = new org.omg.CORBA.StructMember (
            "semestre",
            _tcOf_members0,
            null);
          _tcOf_members0 = academico.DisciplinaHelper.type ();
          _members0[4] = new org.omg.CORBA.StructMember (
            "disciplina",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (academico.TurmaHelper.id (), "Turma", _members0);
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

  public static academico.Turma read (org.omg.CORBA.portable.InputStream istream)
  {
    academico.Turma value = new academico.Turma ();
    value.codigo = istream.read_long ();
    value.nome = istream.read_string ();
    value.ano = istream.read_short ();
    value.semestre = istream.read_short ();
    value.disciplina = academico.DisciplinaHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, academico.Turma value)
  {
    ostream.write_long (value.codigo);
    ostream.write_string (value.nome);
    ostream.write_short (value.ano);
    ostream.write_short (value.semestre);
    academico.DisciplinaHelper.write (ostream, value.disciplina);
  }

}
