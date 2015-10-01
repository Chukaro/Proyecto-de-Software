package Presentation;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CreacionUsuario extends JInternalFrame {

	private JComponent barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarra = null;
	private JTextField txtUsuario;
	private JTextField txtPass;
	private JTextField txtConfirmar;
	private JButton btnGuardar;
	
	public CreacionUsuario() {
		
		quitarBarraTitulo();
		
		setBorder(null);
		setBounds(100, 100, 565, 361);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 565, 335);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Usuario");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 12));
		lblNewLabel.setBounds(39, 48, 162, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(39, 104, 162, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirmar password");
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(39, 165, 162, 14);
		panel.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!BRL.UsuarioBRL.ExisteUsuario(txtUsuario.getText()))
				{
					btnGuardar.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
					btnGuardar.setEnabled(false);
				}
			}
		});
		
		txtUsuario.setBounds(310, 45, 219, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(310, 101, 219, 20);
		panel.add(txtPass);
		txtPass.setColumns(10);
		
		txtConfirmar = new JTextField();
		txtConfirmar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				 if (txtConfirmar.getText().compareTo(txtPass.getText()) == 0 )
				 {
					 btnGuardar.setEnabled(true);
				 }
				 else
				 {
					JOptionPane.showMessageDialog(null, "Campos no son iguales", "ERROR", JOptionPane.ERROR_MESSAGE);
					btnGuardar.setEnabled(false);
				 }
			}
		});
		txtConfirmar.setBounds(310, 162, 219, 20);
		panel.add(txtConfirmar);
		txtConfirmar.setColumns(10);
		
		btnGuardar = new JButton("Crear usuario");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardar.setBounds(67, 269, 175, 32);
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(379, 269, 132, 32);
		panel.add(btnCancelar);

	}

	//quita la barra de titulo
	public void quitarBarraTitulo()
	{ 
		barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
		DimensionBarra = barra.getPreferredSize(); 
		barra.setSize(0,0); 
		barra.setPreferredSize(new Dimension(0,0)); 
		repaint(); 
	}
}
