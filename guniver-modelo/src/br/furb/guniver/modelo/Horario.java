package br.furb.guniver.modelo;

import java.io.Serializable;

public final class Horario implements Serializable {

    private String horario;
    private String sala;

    public Horario() {
    }

    public Horario(String _horario, String _sala) {
	horario = _horario;
	sala = _sala;
    }

    public String getHorario() {
	return horario;
    }

    public void setHorario(String horario) {
	this.horario = horario;
    }

    public String getSala() {
	return sala;
    }

    public void setSala(String sala) {
	this.sala = sala;
    }
}
