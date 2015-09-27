package Presentation;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;

public class prueba3 extends JInternalFrame {
	
	//objetos necesarios para quitar el titulo del JInternalFrame
	private JComponent barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarra = null; 
	
	
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba3 frame = new prueba3();
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
	public prueba3() {
		setResizable(true);
		setFrameIcon(null);
		setBorder(null);
		
		//this.setUI(null);
		setBounds(100, 100, 562, 406);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(555, 375, -554, -373);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 562, 380);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(31, 99, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(42, 213, 89, 23);
		panel_1.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(212, 100, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 214, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		quitarBarraTitulo();
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
