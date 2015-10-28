package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcionesInicio extends JInternalFrame {
	
	//objetos necesarios para quitar el titulo del JInternalFrame
		private JComponent barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		private Dimension DimensionBarra = null;
		private JComboBox comBoxMaterias;
		private JComboBox cmBoxModificar;

	public OpcionesInicio() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(null);
		quitarBarraTitulo();
		setBounds(100, 100, 800, 365);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Elija tipo Fomularios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(22, 116, 756, 103);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSimple = new JButton("Formulario Simple");
		btnSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				PanillaSimple simple = new PanillaSimple();
				
				DAL.Asignatura dato = (DAL.Asignatura)comBoxMaterias.getSelectedItem();
				
				int id = dato.getIdAsignatura();
				String cod = dato.getCodAsignatura();
				String mom = dato.getNombre();
				
				if (id > 0 && mom.length() > 0) {
					simple.datosLabel(Inicio.lblNomUsuario.getText(), mom, cod, id);
					simple.datosTabla(id);
					
					simple.reshape(0, 0, 780, 590);
					
					Inicio.contenedor.reshape(0, 0, 780, 5590);
					Inicio.contenedor.add(simple);
										
					simple.toFront();
					
					simple.setVisible(true);
					//Inicio.contenedor.repaint();
					
					Inicio.frame.setBounds(0, 0, 780, 590);
				} 
				else {
					JOptionPane.showMessageDialog(null, "Materias no asignadas", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnSimple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSimple.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/paste.png")));
		btnSimple.setBounds(25, 24, 226, 49);
		panel.add(btnSimple);
		
		JButton btnAvanzado = new JButton("Formulario Avanzado");
		btnAvanzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAvanzado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAvanzado.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/paste.png")));	
		btnAvanzado.setBounds(503, 24, 243, 49);
		panel.add(btnAvanzado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda Formulario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(22, 247, 341, 81);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 37, 225, 20);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(256, 37, 67, 20);
		panel_1.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Escoger Materia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(224, 11, 357, 72);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		comBoxMaterias = new JComboBox();
		comBoxMaterias.setBounds(10, 24, 241, 20);
		panel_2.add(comBoxMaterias);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(282, 24, 65, 20);
		panel_2.add(comboBox_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Modificar Formulario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(385, 247, 393, 81);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		cmBoxModificar = new JComboBox();
		cmBoxModificar.setBounds(10, 38, 201, 20);
		panel_3.add(cmBoxModificar);
		
		JButton btnModificar = new JButton("Modificar formulario");
		btnModificar.setBounds(233, 37, 150, 23);
		panel_3.add(btnModificar);

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
	
	public void comBoxMateriasIngreso(List<DAL.Asignatura> materias)
	{   
		if(materias.size() !=0)
		{
			for (int i = 0; i < materias.size(); i++) {
				comBoxMaterias.addItem(materias.get(i));
			}
		}
	}
	
	public void cmBoxMatFormulario(List<DAL.Asignatura> materias)
	{   
		if(materias.size() !=0)
		{
			for (int i = 0; i < materias.size(); i++) {
				cmBoxModificar.addItem(materias.get(i));
			}
		}
	}

}
