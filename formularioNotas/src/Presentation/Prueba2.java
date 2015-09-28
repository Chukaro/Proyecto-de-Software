package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prueba2 {

	private JFrame frame;
	private JDesktopPane contenedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba2 window = new Prueba2();
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
	public Prueba2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 627, 518);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		contenedor = new JDesktopPane();
		contenedor.setBounds(0, 0, 627, 496);
		panel.add(contenedor);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmNuemi = new JMenuItem("menu 1");
		mntmNuemi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prueba3 prueba = new prueba3();
				contenedor.add(prueba);
				prueba.reshape(0, 0, 800, 600);
				prueba.setVisible(true);
				/*
				 * 	this.setBounds(0, 0, anchoPrincipal, altoPrincipal);
        			this.getContentPane().removeAll();
        			this.getContentPane().add(v);
        			this.repaint();
				 * */
			}
		});
		
		mnInicio.add(mntmNuemi);
		
		JMenuItem mntmMenu = new JMenuItem("menu 2");
		mnInicio.add(mntmMenu);
	}
}
