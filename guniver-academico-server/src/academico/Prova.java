package academico;


/**
* academico/Prova.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 21h55min02s BRST
*/

public final class Prova implements org.omg.CORBA.portable.IDLEntity
{
  public String descricao = null;
  public academico.Aluno aluno = null;
  public academico.Turma turma = null;
  public float nota = (float)0;

  public Prova ()
  {
  } // ctor

  public Prova (String _descricao, academico.Aluno _aluno, academico.Turma _turma, float _nota)
  {
    descricao = _descricao;
    aluno = _aluno;
    turma = _turma;
    nota = _nota;
  } // ctor

} // class Prova
