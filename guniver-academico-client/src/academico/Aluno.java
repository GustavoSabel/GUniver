package academico;


/**
* academico/Aluno.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 26 de Novembro de 2014 00h01min29s BRST
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
