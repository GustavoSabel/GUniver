package br.furb.guniver.ui.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.furb.guniver.ui.utils.UIUtils;

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
	private Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIUtils.changeLookAndFeelIfPossible(UIUtils.SupportedLookAndFeel.SYSTEM_DEFAULT);

					MainConsole window = new MainConsole(new Controller());
					UIUtils.centerOnScreen(window.frmGuniverManager);
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
	public MainConsole(Controller controller) {
		this.controller = controller;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuniverManager = new JFrame();
		frmGuniverManager.setMinimumSize(new Dimension(450, 350));
		frmGuniverManager.setSize(new Dimension(600, 500));
		frmGuniverManager.setTitle("GUniver Manager");
		frmGuniverManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuniverManager.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel stage = new JPanel();
		frmGuniverManager.getContentPane().add(stage, BorderLayout.CENTER);

		LateralMenu lateralMenu = new LateralMenu(stage);
		frmGuniverManager.getContentPane().add(lateralMenu, BorderLayout.WEST);
	}

}
