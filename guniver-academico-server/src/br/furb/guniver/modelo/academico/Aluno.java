package br.furb.guniver.modelo.academico;


/**
* br/furb/guniver/modelo/academico/Aluno.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Ter�a-feira, 2 de Dezembro de 2014 23h28min37s BRST
*/

public final class Aluno implements org.omg.CORBA.portable.IDLEntity
{
  public int codigo = (int)0;
  public String nome = null;

  public Aluno ()
  {
  } // ctor

  public Aluno (int _codigo, String _nome)
  {
    codigo = _codigo;
    nome = _nome;
  } // ctor

} // class Aluno
