package Presentation;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Login {

	private JFrame frmSaagaf;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	

	public JFrame getFrame() {
		return frmSaagaf;
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSaagaf = new JFrame();
		frmSaagaf.setResizable(false);
		frmSaagaf.setTitle("Ingreso de Usuario");
		frmSaagaf.getContentPane().setForeground(Color.BLACK);
		frmSaagaf.getContentPane().setBackground(Color.GRAY);
		frmSaagaf.setBounds(100, 100, 392, 217);
		frmSaagaf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaagaf.getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(79, 26, 111, 20);
		frmSaagaf.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIngreso = new JButton("Ingresar");
		btnIngreso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnIngreso.setBackground(Color.WHITE);
		btnIngreso.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/check.png")));
		btnIngreso.setForeground(Color.BLUE);
		
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = txtUsuario.getText();
				//asi se recupera el campo text password
				char[] pass = txtPassword.getPassword();
				String pass1 = new String(pass);
				
				
				
				Main.Main.setIdDocente(BRL.UsuarioBRL.VerficaUser(usuario, pass1));
				//aqui se modifico para utilizar programacion por capas BRL - DAL
				if(Main.Main.getIdDocente() > 0){
						
					Inicio ventana = new Inicio();
									
					//ventana.datosDocente(idDocente);
					ventana.getFrame().setVisible(true);
					frmSaagaf.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Error de Usuario", "ERROR DE SESION", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnIngreso.setBounds(58, 134, 118, 33);
		frmSaagaf.getContentPane().add(btnIngreso);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/close.png")));
		btnCancel.setForeground(Color.BLACK);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(212, 134, 128, 33);
		frmSaagaf.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 32, 46, 14);
		frmSaagaf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBackground(SystemColor.controlText);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 72, 81, 14);
		frmSaagaf.getContentPane().add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(79, 70, 111, 20);
		frmSaagaf.getContentPane().add(txtPassword);
		
		JLabel lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Padlock_User_Control_Icon_128.png")));
		lblImagen.setBounds(222, 0, 118, 115);
		frmSaagaf.getContentPane().add(lblImagen);
	}
}
