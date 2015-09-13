package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Inicio {

	private JFrame frame;

	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSimple = new JButton("New button");
		btnSimple.setBounds(45, 107, 89, 23);
		frame.getContentPane().add(btnSimple);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(272, 107, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
