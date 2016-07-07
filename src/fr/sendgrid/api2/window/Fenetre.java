package fr.sendgrid.api2.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	// private Panneau pan = new Panneau();
	private JButton bouton = new JButton("Go");
	private JButton bouton2 = new JButton("Stop");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Choix de la forme");
	private int compteur = 0;
	private boolean animated = true;
	private boolean backX, backY;
	private int x, y;
	private Thread t;
	private JComboBox combo = new JComboBox();

	private JCheckBox morph = new JCheckBox("Morphing");

	public Fenetre() {
		String tab[] = { "Option1", "Optien2", "Option3", "Option4" };
		combo = new JComboBox(tab);
		// Ajout du listener
		combo.addItemListener(new ItemState());
		combo.addActionListener(new ItemAction());
		combo.setPreferredSize(new Dimension(100, 20));
		combo.setForeground(Color.blue);

		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		combo.setPreferredSize(new Dimension(100, 20));

		JPanel top = new JPanel();
		top.add(label);
		top.add(combo);
		container.add(top, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
	}

	// Classe interne implémentant l'interface ItemListener
	class ItemState implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			System.out.println("événement déclenché sur : " + e.getItem());
		}
	}

	class ItemAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("ActionListener : action sur " + combo.getSelectedItem());
		}
	}
}