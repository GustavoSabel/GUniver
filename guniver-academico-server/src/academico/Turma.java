package academico;


/**
* academico/Turma.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 21h55min02s BRST
*/

public final class Turma implements org.omg.CORBA.portable.IDLEntity
{
  public int codigo = (int)0;
  public String nome = null;
  public short ano = (short)0;
  public short semestre = (short)0;
  public academico.Disciplina disciplina = null;

  public Turma ()
  {
  } // ctor

  public Turma (int _codigo, String _nome, short _ano, short _semestre, academico.Disciplina _disciplina)
  {
    codigo = _codigo;
    nome = _nome;
    ano = _ano;
    semestre = _semestre;
    disciplina = _disciplina;
  } // ctor

} // class Turma
