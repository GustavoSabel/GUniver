package br.furb.guniver.ui.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class LateralMenu extends JPanel {

	private final AlunoFragment fragmentAluno;
	private final CursoFragment fragmentCurso;
	private final DisciplinaFragment fragmentDisciplina;
	private final ProvaFragment fragmentProva;
	private final TurmaFragment fragmentTurma;

	private final WebServicesFragment fragmentWebServices;

	private JPanel stage;
	private JButton btnAluno;
	private JButton btnCurso;
	private JButton btnDisciplina;
	private JButton btnProva;
	private JButton btnTurma;
	private JButton btnWebServices;

	private Fragment activeFragment;

	public LateralMenu(JPanel stage, Controller controller) {
		Font buttonsFont = new Font("Segoe UI Semibold", Font.PLAIN, 18);
		Dimension buttonsPreferredSize = new Dimension(150, 40);

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setStage(stage);
		setBackground(SystemColor.controlHighlight);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 75, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 23, 23, 0, 23, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		btnAluno = new JButton("Aluno");
		btnAluno.setFont(buttonsFont);
		btnAluno.setPreferredSize(buttonsPreferredSize);
		btnAluno.addActionListener(actionListener);
		GridBagConstraints gbc_btnAluno = new GridBagConstraints();
		gbc_btnAluno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAluno.insets = new Insets(2, 2, 5, 2);
		gbc_btnAluno.gridx = 0;
		gbc_btnAluno.gridy = 0;
		add(btnAluno, gbc_btnAluno);

		btnCurso = new JButton("Curso");
		btnCurso.setFont(buttonsFont);
		btnCurso.setPreferredSize(buttonsPreferredSize);
		btnCurso.addActionListener(actionListener);
		GridBagConstraints gbc_btnCurso = new GridBagConstraints();
		gbc_btnCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCurso.insets = new Insets(0, 2, 5, 2);
		gbc_btnCurso.gridx = 0;
		gbc_btnCurso.gridy = 1;
		add(btnCurso, gbc_btnCurso);

		btnDisciplina = new JButton("Disciplina");
		btnDisciplina.setFont(buttonsFont);
		btnDisciplina.setPreferredSize(buttonsPreferredSize);
		btnDisciplina.addActionListener(actionListener);
		GridBagConstraints gbc_btnDisciplina = new GridBagConstraints();
		gbc_btnDisciplina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisciplina.insets = new Insets(0, 2, 5, 2);
		gbc_btnDisciplina.gridx = 0;
		gbc_btnDisciplina.gridy = 2;
		add(btnDisciplina, gbc_btnDisciplina);

		btnTurma = new JButton("Turma");
		btnTurma.setFont(buttonsFont);
		btnTurma.setPreferredSize(buttonsPreferredSize);
		btnTurma.addActionListener(actionListener);

		btnProva = new JButton("Prova");
		btnProva.setPreferredSize(new Dimension(150, 40));
		btnProva.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnProva.addActionListener(actionListener);
		GridBagConstraints gbc_btnProva = new GridBagConstraints();
		gbc_btnProva.insets = new Insets(0, 0, 5, 0);
		gbc_btnProva.gridx = 0;
		gbc_btnProva.gridy = 3;
		add(btnProva, gbc_btnProva);
		GridBagConstraints gbc_btnTurma = new GridBagConstraints();
		gbc_btnTurma.insets = new Insets(0, 2, 5, 2);
		gbc_btnTurma.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTurma.gridx = 0;
		gbc_btnTurma.gridy = 4;
		add(btnTurma, gbc_btnTurma);

		btnWebServices = new JButton("Web Services");
		btnWebServices.setPreferredSize(buttonsPreferredSize);
		btnWebServices.setFont(buttonsFont);
		btnWebServices.addActionListener(actionListener);
		GridBagConstraints gbc_btnWebServices = new GridBagConstraints();
		gbc_btnWebServices.insets = new Insets(0, 2, 1, 2);
		gbc_btnWebServices.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWebServices.gridx = 0;
		gbc_btnWebServices.gridy = 5;
		add(btnWebServices, gbc_btnWebServices);

		fragmentAluno = new AlunoFragment();
		fragmentCurso = new CursoFragment();
		fragmentDisciplina = new DisciplinaFragment();
		fragmentTurma = new TurmaFragment();
		fragmentProva = new ProvaFragment();
		fragmentWebServices = new WebServicesFragment(controller);

		switchToFragment(fragmentWebServices);
	}

	private ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton src = (JButton) e.getSource();
			Fragment fragment;
			if (src == btnAluno) {
				fragment = fragmentAluno;
			} else if (src == btnCurso) {
				fragment = fragmentCurso;
			} else if (src == btnDisciplina) {
				fragment = fragmentDisciplina;
			} else if (src == btnProva) {
				fragment = fragmentProva;
			} else if (src == btnTurma) {
				fragment = fragmentTurma;
			} else if (src == btnWebServices) {
				fragment = fragmentWebServices;
			} else {
				return;
			}
			switchToFragment(fragment);
		}
	};

	private void switchToFragment(Fragment fragment) {
		if (activeFragment == fragment || (activeFragment != null && !activeFragment.canExit())) {
			return;
		}
		if (activeFragment != null) {
			activeFragment.onExit();
			stage.remove(activeFragment);
		}
		stage.add(fragment, BorderLayout.CENTER);
		stage.revalidate();
		stage.repaint();
		this.activeFragment = fragment;
		fragment.onEnter();
	}

	public void setStage(JPanel stage) {
		if (stage == null) {
			throw new NullPointerException("stage is null");
		}
		this.stage = stage;
		stage.setLayout(new BorderLayout());
	}

	public JPanel getStage() {
		return stage;
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		btnAluno.setEnabled(enabled);
		btnCurso.setEnabled(enabled);
		btnDisciplina.setEnabled(enabled);
		btnTurma.setEnabled(enabled);
	}

}
