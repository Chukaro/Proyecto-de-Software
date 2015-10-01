package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	private JFrame frame;
	private JDesktopPane contenedor;

	
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
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 706, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		contenedor = new JDesktopPane();
		contenedor.setBounds(0, 0, 750, 332);
		frame.getContentPane().add(contenedor);
		
		opcionesPrincipal();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		frame.setJMenuBar(menuBar);
		
		JMenu mnFormulario = new JMenu("Formulario");
		mnFormulario.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		mnFormulario.setBackground(new Color(0, 128, 128));
		mnFormulario.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/paste.png")));
		menuBar.add(mnFormulario);
		
		JMenuItem mntmSimple = new JMenuItem("Simple");
		mnFormulario.add(mntmSimple);
		
		JMenuItem mntmAvanzado = new JMenuItem("Avanzado");
		mnFormulario.add(mntmAvanzado);
		
		JMenu mnBuscarEstudiante = new JMenu("Buscar Estudiante");
		mnBuscarEstudiante.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		mnBuscarEstudiante.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/zoom.png")));
		menuBar.add(mnBuscarEstudiante);
		
		JMenu mnInformes = new JMenu("Informes");
		mnInformes.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		mnInformes.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/report.png")));
		menuBar.add(mnInformes);
		
		JMenuItem mntmAprobados = new JMenuItem("Aprobados");
		mnInformes.add(mntmAprobados);
		
		JMenuItem mntmReprobados = new JMenuItem("Reprobados");
		mnInformes.add(mntmReprobados);
		
		JMenu mnCuenta = new JMenu("Cuenta");
		mnCuenta.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		mnCuenta.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/user.png")));	
		menuBar.add(mnCuenta);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
		mnCuenta.add(mntmCambiarContrasea);
		
		JMenu mnCrearUsuario = new JMenu("Crear Usuario");
	
		mnCrearUsuario.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		mnCrearUsuario.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/user_add.png")));
		menuBar.add(mnCrearUsuario);
		
		JMenuItem mntmNuevoUsuario = new JMenuItem("Nuevo usuario");
		mntmNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreacionUsuario creacionUsuario = new CreacionUsuario();
				creacionUsuario.reshape(0, 0, 700, 332);
				contenedor.removeAll();
				contenedor.add(creacionUsuario);
				creacionUsuario.setVisible(true);
				contenedor.repaint();
				frame.setBounds(0, 0, 650, 400);
			}
		});
		mnCrearUsuario.add(mntmNuevoUsuario);

		
	}
	
	private void opcionesPrincipal()
	{
		//se ingresa el JInternalFrame
		OpcionesInicio opInicio = new OpcionesInicio();
		opInicio.reshape(0, 0, 700, 332);
		//opInicio.reshape(0, 0, 1200, 600);
		//contenedor.setBounds(0, 0, 700, 332);
		//this.getContentPane().removeAll();
		contenedor.removeAll();
		//this.getContentPane().add(v);
		contenedor.add(opInicio);
		opInicio.setVisible(true);
		contenedor.repaint();
		frame.setBounds(0, 0, 725, 432);
		//this.repaint();
	}
}
