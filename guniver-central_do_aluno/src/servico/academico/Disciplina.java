package servico.academico;


/**
* academico/Disciplina.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Domingo, 30 de Novembro de 2014 22h44min29s BRST
*/

public final class Disciplina implements org.omg.CORBA.portable.IDLEntity
{
  public int codigo = (int)0;
  public String nome = null;

  public Disciplina ()
  {
  } // ctor

  public Disciplina (int _codigo, String _nome)
  {
    codigo = _codigo;
    nome = _nome;
  } // ctor

} // class Disciplina
