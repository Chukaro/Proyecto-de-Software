package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class OpcionesInicio extends JInternalFrame {
	
	//objetos necesarios para quitar el titulo del JInternalFrame
		private JComponent barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		private Dimension DimensionBarra = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcionesInicio frame = new OpcionesInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpcionesInicio() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(null);
		quitarBarraTitulo();
		setBounds(100, 100, 712, 365);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new TitledBorder(null, "Fomularios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 14, 680, 103);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSimple = new JButton("Simple");
		btnSimple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSimple.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/paste.png")));
		btnSimple.setBounds(59, 24, 139, 49);
		panel.add(btnSimple);
		
		JButton btnAvanzado = new JButton("Avanzado");
		btnAvanzado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAvanzado.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/paste.png")));	
		btnAvanzado.setBounds(475, 24, 154, 49);
		panel.add(btnAvanzado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda Formulario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(231, 141, 258, 81);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 37, 119, 20);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 37, 67, 20);
		panel_1.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBorder(new TitledBorder(null, "Materia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(231, 249, 258, 72);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 24, 117, 20);
		panel_2.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(167, 24, 65, 20);
		panel_2.add(comboBox_3);

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
