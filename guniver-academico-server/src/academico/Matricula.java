package academico;


/**
* academico/Matricula.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Domingo, 30 de Novembro de 2014 22h44min29s BRST
*/

public final class Matricula implements org.omg.CORBA.portable.IDLEntity
{
  public academico.Aluno aluno = null;
  public academico.Turma turma = null;

  public Matricula ()
  {
  } // ctor

  public Matricula (academico.Aluno _aluno, academico.Turma _turma)
  {
    aluno = _aluno;
    turma = _turma;
  } // ctor

} // class Matricula
