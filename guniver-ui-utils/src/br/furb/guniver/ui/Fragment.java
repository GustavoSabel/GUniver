package br.furb.guniver.ui;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Fragment extends JPanel {

	@SuppressWarnings("static-method")
	public boolean canExit() {
		return true;
	}

	public void onEnter() {
	}

	public void onExit() {
	}

	public abstract String getTitle();

}
