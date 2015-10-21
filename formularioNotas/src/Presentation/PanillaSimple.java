package Presentation;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class PanillaSimple extends JInternalFrame {

	//objetos necesarios para quitar el titulo del JInternalFrame
		private JComponent barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		private Dimension DimensionBarra = null; 
		private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanillaSimple frame = new PanillaSimple();
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
	public PanillaSimple() {
		setResizable(true);
		setBounds(100, 100, 787, 431);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblMateria = new JLabel("Materia:");
		
		JLabel lblSemestre = new JLabel("Semestre:");
		
		JLabel lblNewLabel = new JLabel("Docente:");
		
		JLabel lblNewLabel_1 = new JLabel("Gestion:");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\MIGUEL\\git\\Proyecto-de-Software\\Proyecto-de-Software\\Proyecto-de-Software\\Proyecto-de-Software\\formularioNotas\\src\\Imagenes\\logocrg.gif"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_5))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_4))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSemestre)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_3))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMateria)
									.addGap(18)
									.addComponent(lblNewLabel_2)))
							.addGap(483)
							.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
							.addGap(103))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMateria)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSemestre)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_4))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_5)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(31)))
					.addGap(58)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(80))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "Nombre", "Paterno", "Materno", "Nota 1", "Nota 2", "Nota 3", "Promedio", "Observacion"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
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
