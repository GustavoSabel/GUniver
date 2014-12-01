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

	private JPanel stage;
	private JButton btnAluno;
	private JButton btnCurso;
	private JButton btnDisciplina;
	private JButton btnTurma;

	private Fragment activeFragment;

	public LateralMenu(JPanel stage) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setStage(stage);
		setBackground(SystemColor.controlHighlight);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 75, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 23, 23, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		btnAluno = new JButton("Aluno");
		btnAluno.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnAluno.setPreferredSize(new Dimension(140, 40));
		btnAluno.addActionListener(actionListener);
		GridBagConstraints gbc_btnAluno = new GridBagConstraints();
		gbc_btnAluno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAluno.insets = new Insets(2, 2, 2, 2);
		gbc_btnAluno.gridx = 0;
		gbc_btnAluno.gridy = 0;
		add(btnAluno, gbc_btnAluno);

		btnCurso = new JButton("Curso");
		btnCurso.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnCurso.setPreferredSize(new Dimension(140, 40));
		btnCurso.addActionListener(actionListener);
		GridBagConstraints gbc_btnCurso = new GridBagConstraints();
		gbc_btnCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCurso.insets = new Insets(0, 2, 2, 2);
		gbc_btnCurso.gridx = 0;
		gbc_btnCurso.gridy = 1;
		add(btnCurso, gbc_btnCurso);

		btnDisciplina = new JButton("Disciplina");
		btnDisciplina.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnDisciplina.setPreferredSize(new Dimension(140, 40));
		btnDisciplina.addActionListener(actionListener);
		GridBagConstraints gbc_btnDisciplina = new GridBagConstraints();
		gbc_btnDisciplina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisciplina.insets = new Insets(0, 2, 2, 2);
		gbc_btnDisciplina.gridx = 0;
		gbc_btnDisciplina.gridy = 2;
		add(btnDisciplina, gbc_btnDisciplina);

		btnTurma = new JButton("Turma");
		btnTurma.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnTurma.setPreferredSize(new Dimension(140, 40));
		btnTurma.addActionListener(actionListener);
		GridBagConstraints gbc_btnTurma = new GridBagConstraints();
		gbc_btnTurma.insets = new Insets(0, 2, 2, 2);
		gbc_btnTurma.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTurma.gridx = 0;
		gbc_btnTurma.gridy = 3;
		add(btnTurma, gbc_btnTurma);
	}

	private ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton src = (JButton) e.getSource();
			Fragment fragment;
			if (src == btnAluno) {
				fragment = new AlunoFragment();
			} else if (src == btnCurso) {
				fragment = new CursoFragment();
			} else if (src == btnDisciplina) {
				fragment = new DisciplinaFragment();
			} else if (src == btnTurma) {
				fragment = new TurmaFragment();
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
