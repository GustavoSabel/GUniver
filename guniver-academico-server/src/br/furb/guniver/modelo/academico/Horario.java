package br.furb.guniver.modelo.academico;


/**
* br/furb/guniver/modelo/academico/Horario.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Academico.idl
* Segunda-feira, 1 de Dezembro de 2014 22h19min19s BRST
*/

public final class Horario implements org.omg.CORBA.portable.IDLEntity
{
  public String horario = null;
  public String sala = null;

  public Horario ()
  {
  } // ctor

  public Horario (String _horario, String _sala)
  {
    horario = _horario;
    sala = _sala;
  } // ctor

} // class Horario