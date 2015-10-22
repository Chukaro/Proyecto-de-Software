package Presentation;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Inicio {

	public static JFrame frame;
	public static JDesktopPane contenedor;
	public static JLabel lblNomUsuario;
	private OpcionesInicio opInicio = new OpcionesInicio();
	private JMenuItem mntmNuevoUsuario;

	
	public JDesktopPane getContenedor() {
		return contenedor;
	}
	
	public JLabel getLblNomUsuario() {
		return lblNomUsuario;
	}
	
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
		mnFormulario.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnFormulario.setBackground(new Color(0, 128, 128));
		mnFormulario.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/paste.png")));
		menuBar.add(mnFormulario);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcionesPrincipal();
			}
		});
		
		mnFormulario.add(mntmInicio);
		
		JMenuItem mntmSimple = new JMenuItem("Simple");
		mntmSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanillaSimple simple = new PanillaSimple();
				
				//DAL.Asignatura dato = (DAL.Asignatura)comBoxMaterias.getSelectedItem();
				
				//int id = dato.getIdAsignatura();
				//String cod = dato.getCodAsignatura();
				//String mom = dato.getNombre();
				
				simple.datosLabel(lblNomUsuario.getText(), "Materia", "Codigo");
				
				
				simple.reshape(0, 0, 1200, 700);
				contenedor.setBounds(0, 0, 1200, 720);
				contenedor.removeAll();
				contenedor.add(simple);
				simple.setVisible(true);
				contenedor.repaint();
				frame.setBounds(0, 0, 1200, 700);	
			}
		});
		mnFormulario.add(mntmSimple);
		
		JMenuItem mntmAvanzado = new JMenuItem("Avanzado");
		mnFormulario.add(mntmAvanzado);
		
		JMenu mnBuscarEstudiante = new JMenu("Buscar Estudiante");
		mnBuscarEstudiante.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnBuscarEstudiante.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/zoom.png")));
		menuBar.add(mnBuscarEstudiante);
		
		JMenu mnInformes = new JMenu("Informes");
		mnInformes.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnInformes.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/report.png")));
		menuBar.add(mnInformes);
		
		JMenuItem mntmAprobados = new JMenuItem("Aprobados");
		mnInformes.add(mntmAprobados);
		
		JMenuItem mntmReprobados = new JMenuItem("Reprobados");
		mnInformes.add(mntmReprobados);
		
		JMenu mnCuenta = new JMenu("Cuenta");
		mnCuenta.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnCuenta.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/user.png")));	
		menuBar.add(mnCuenta);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
		mnCuenta.add(mntmCambiarContrasea);
		
		JMenu mnCrearUsuario = new JMenu("Crear Usuario");
	
		mnCrearUsuario.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnCrearUsuario.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/user_add.png")));
		menuBar.add(mnCrearUsuario);
		
		mntmNuevoUsuario = new JMenuItem("Nuevo usuario");
		mntmNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarNuevoUsuario();
			}
		});
		
		mnCrearUsuario.add(mntmNuevoUsuario);
		
		lblNomUsuario = new JLabel("New label");
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(lblNomUsuario);
		
		mntmNuevoUsuario.setEnabled(false);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window = new Login();
				window.getFrame().setVisible(true);
				frame.setVisible(false);
			}
			
		});
		btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/user_black.png")));
		menuBar.add(btnSalir);
		
	}
	
	public void opcionesPrincipal()
	{
		//se ingresa el JInternalFrame
		opInicio.reshape(0, 0, 1200, 720);
		//opInicio.reshape(0, 0, 1200, 600);
		contenedor.setBounds(0, 0, 1200, 720);
		//this.getContentPane().removeAll();
		contenedor.removeAll();
		//this.getContentPane().add(v);
		contenedor.add(opInicio);
		opInicio.setVisible(true);
		contenedor.repaint();
		frame.setBounds(0, 0, 1200, 720);
		//this.repaint();
	}
	
	private void nombreUsuario(String nombre)
	{
		lblNomUsuario.setText(nombre + "  ");	
	}
	
	public void mostrarNuevoUsuario()
	{
		CreacionUsuario creacionUsuario = new CreacionUsuario();
		creacionUsuario.reshape(0, 0, 700, 332);
		contenedor.removeAll();
		contenedor.add(creacionUsuario);
		creacionUsuario.setVisible(true);
		contenedor.repaint();
		frame.setBounds(0, 0, 650, 400);		
	}
	
	public void datosDocente(int id)
	{
		DAL.Docente infDocente = BRL.DocenteBRL.InformacionDocente(id);
		
		if (infDocente.getUsuario().getCargo().compareTo("Administrador") == 0)
			mntmNuevoUsuario.setEnabled(true);
		//se deshabilita la opcion de crear usuario
		
		
		nombreUsuario(infDocente.getNombre());
		
		opInicio.comBoxMateriasIngreso(infDocente.getMaterias());
	}
}
