package academico;


/**
* academico/Curso.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Quarta-feira, 19 de Novembro de 2014 00h27min51s BRST
*/

public final class Curso implements org.omg.CORBA.portable.IDLEntity
{
  public int codigo = (int)0;
  public String nome = null;

  public Curso ()
  {
  } // ctor

  public Curso (int _codigo, String _nome)
  {
    codigo = _codigo;
    nome = _nome;
  } // ctor

} // class Curso