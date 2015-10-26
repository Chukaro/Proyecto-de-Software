package Presentation;

import java.awt.Dimension;
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
import java.util.List;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

public class CreacionUsuario extends JInternalFrame {

	private JComponent barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarra = null;
	private JTextField txtUsuario;
	private JButton btnGuardar;
	private JComboBox cmBoxDocente;
	private JLabel lblCodigo;
	private JLabel lblId;
	private JLabel lblCodigoDocente;
	private JPasswordField txtPassword;
	private JPasswordField txtVerificacion;
	private JComboBox cmBoxCargo;
	
	private DAL.Docente valorDefecto;
	
	//private Inicio i = new Inicio();
	
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
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setBounds(20, 88, 162, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(20, 133, 162, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirmar password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(20, 185, 162, 14);
		panel.add(lblNewLabel_2);
		
		lblId = new JLabel("New label");
		lblId.setBounds(489, 61, 46, 14);
		
		//lblId.setVisible(false);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(260, 86, 219, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblCodigo = new JLabel("codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(260, 60, 120, 14);
		
		cmBoxDocente = new JComboBox();
		cmBoxDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAL.Docente escogido = (DAL.Docente) cmBoxDocente.getSelectedItem();
				if (escogido != null) {
					lblCodigo.setText(escogido.getCodDocente());
					lblId.setText(escogido.getId()+"");
				}
			}
		});
				
		btnGuardar = new JButton("Crear usuario");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] password = txtPassword.getPassword();
				String clave = new String(password);
				String cargo = (String)cmBoxCargo.getSelectedItem();
				try{
					BRL.UsuarioBRL.CrearUsuario(txtUsuario.getText(), clave, Integer.parseInt(lblId.getText()), cargo );
					limpiarText();
				}
			 	catch(Exception e){
			      //Handle errors for Class.forName
			 		JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);;
				}
				
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardar.setBounds(20, 292, 175, 32);
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(267, 292, 132, 32);
		panel.add(btnCancelar);
		
		
		cmBoxDocente.setBounds(260, 11, 275, 20);
		panel.add(cmBoxDocente);
		
		JLabel lblDocente = new JLabel("Docente");
		lblDocente.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblDocente.setBounds(20, 13, 94, 14);
		panel.add(lblDocente);
		
		
		panel.add(lblCodigo);
		
		
		panel.add(lblId);
		
		lblCodigoDocente = new JLabel("Codigo Docente");
		lblCodigoDocente.setBounds(70, 61, 112, 14);
		panel.add(lblCodigoDocente);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				char[] pass1 = txtPassword.getPassword();
				String pass1a = new String(pass1);
				
				char[] pass2 = txtVerificacion.getPassword();
				String pass2a = new String(pass2);
				
				if(verificacionIgual(pass1a, pass2a))
				{
					btnGuardar.setEnabled(true);
				}
				else
				{
					btnGuardar.setEnabled(false);
				}
			}
		});
		txtPassword.setBounds(260, 131, 219, 20);
		panel.add(txtPassword);
		
		txtVerificacion = new JPasswordField();
		txtVerificacion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				//asi se recupera el campo text password
				char[] pass1 = txtPassword.getPassword();
				String pass1a = new String(pass1);
				
				char[] pass2 = txtVerificacion.getPassword();
				String pass2a = new String(pass2);
				
				if(verificacionIgual(pass1a, pass2a))
				{
					btnGuardar.setEnabled(true);
				}
				else
				{
					btnGuardar.setEnabled(false);
				}
			}
		});
		txtVerificacion.setBounds(260, 183, 219, 20);
		panel.add(txtVerificacion);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(20, 240, 46, 14);
		panel.add(lblNewLabel_3);
		
		cmBoxCargo = new JComboBox();
		cmBoxCargo.setFont(new Font("Tahoma", Font.ITALIC, 12));
		cmBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Docente"}));
		cmBoxCargo.setBounds(260, 237, 139, 20);
		panel.add(cmBoxCargo);
		
		llenarCmBoxDocente();

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
	
	private void llenarCmBoxDocente()
	{
		List<DAL.Docente> listaDocente = BRL.DocenteBRL.Docentes(); 
		
		valorDefecto = new DAL.Docente();
		
		if(listaDocente != null)
		{
			valorDefecto = listaDocente.get(0);
			
			for (int i = 0; i < listaDocente.size(); i++) {
				cmBoxDocente.addItem(listaDocente.get(i));
			}
		}
	}
	
	private boolean verificacionIgual(String palabra, String palabra2)
	{
		boolean verifica = false;
		if (palabra.compareTo(palabra2) == 0) {
			verifica = true;
		}
		
		return verifica;
		
	}
	
	private void limpiarText()
	{
		txtUsuario.setText(null);
		txtPassword.setText(null);
		txtVerificacion.setText(null);
		this.cmBoxDocente.setSelectedItem(valorDefecto);
	}
}
