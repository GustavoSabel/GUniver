package br.furb.guniver.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

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

	private JFrame frmGuniverManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (Exception ex) {
						ex.printStackTrace();
					}

					MainConsole window = new MainConsole();
					window.frmGuniverManager.setVisible(true);
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
		frmGuniverManager = new JFrame();
		frmGuniverManager.setTitle("GUniver Manager");
		frmGuniverManager.setBounds(100, 100, 450, 300);
		frmGuniverManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuniverManager.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel stage = new JPanel();
		frmGuniverManager.getContentPane().add(stage, BorderLayout.CENTER);

		LateralMenu lateralMenu = new LateralMenu(stage);
		frmGuniverManager.getContentPane().add(lateralMenu, BorderLayout.WEST);
	}

}
