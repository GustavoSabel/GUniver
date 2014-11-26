package br.furb.guniver.ui.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Janela principal do GUniver Manager.<br>
 * Através dela é possível:
 * <ul>
 * <li>cadastrar alunos (usuário e senha);</li>
 * <li>cadastrar disciplinas;</li>
 * <li>cadastrar turma; e</li>
 * <li>cadastrar provas.</li>
 * </ul>
 */
public class MainConsole {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainConsole window = new MainConsole();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainConsole() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
