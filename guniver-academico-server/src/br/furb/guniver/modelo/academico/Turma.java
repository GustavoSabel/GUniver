package br.furb.guniver.modelo.academico;


/**
* br/furb/guniver/modelo/academico/Turma.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Segunda-feira, 1 de Dezembro de 2014 22h19min19s BRST
*/

public final class Turma implements org.omg.CORBA.portable.IDLEntity
{
  public int codigo = (int)0;
  public short ano = (short)0;
  public short semestre = (short)0;
  public br.furb.guniver.modelo.academico.Disciplina disciplina = null;

  public Turma ()
  {
  } // ctor

  public Turma (int _codigo, short _ano, short _semestre, br.furb.guniver.modelo.academico.Disciplina _disciplina)
  {
    codigo = _codigo;
    ano = _ano;
    semestre = _semestre;
    disciplina = _disciplina;
  } // ctor

} // class Turma