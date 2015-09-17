package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import java.awt.Panel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fomularios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Simple");
		btnNewButton.setBounds(28, 34, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Avanzado");
		btnNewButton_1.setBounds(267, 34, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda Formulario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 106, 414, 58);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 27, 119, 20);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(165, 27, 67, 20);
		panel_1.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Materia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 175, 414, 55);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 24, 117, 20);
		panel_2.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(167, 24, 65, 20);
		panel_2.add(comboBox_3);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFormulario = new JMenu("Formulario");
		menuBar.add(mnFormulario);
		
		JMenuItem mntmSimple = new JMenuItem("Simple");
		mnFormulario.add(mntmSimple);
		
		JMenuItem mntmAvanzado = new JMenuItem("Avanzado");
		mnFormulario.add(mntmAvanzado);
		
		JMenu mnBuscarEstudiante = new JMenu("Buscar Estudiante");
		menuBar.add(mnBuscarEstudiante);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenuItem mntmAprobados = new JMenuItem("Aprobados");
		mnInformes.add(mntmAprobados);
		
		JMenuItem mntmReprobados = new JMenuItem("Reprobados");
		mnInformes.add(mntmReprobados);
		
		JMenu mnCuente = new JMenu("Cuenta");
		menuBar.add(mnCuente);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
		mnCuente.add(mntmCambiarContrasea);
		
		JMenu mnCrearUsuario = new JMenu("Crear Usuario");
		menuBar.add(mnCrearUsuario);
	}
}
