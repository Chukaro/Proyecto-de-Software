package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import DAL.Conextion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtPass;

	

	public JFrame getFrame() {
		return frame;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(221, 76, 86, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(221, 146, 86, 20);
		frame.getContentPane().add(txtPass);
		txtPass.setColumns(10);
		
		JButton btnIngreso = new JButton("Ingresar");
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = txtUsuario.getText();
				String pass = txtPass.getText();
				
				Conextion con = Conextion.getConexion();
				String consulta = "select * from usuario where usuario = '"+usuario+"' and password = '"+pass+"'";
				con.setConsulta(consulta);
				con.consultar();
				
				try {
					if (con.getListaResultado().last()){
						Inicio ventana = new Inicio();
						ventana.getFrame().setVisible(true);
						frame.setVisible(false);
					}
					else{
						//JOptionPane.showMessageDialog(null, "No exsite el usuario","ERROR");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnIngreso.setBounds(75, 201, 89, 23);
		frame.getContentPane().add(btnIngreso);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancel.setBounds(233, 201, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(58, 79, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(58, 149, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
