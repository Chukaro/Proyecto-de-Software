package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import DAL.TModel;
import DAL.CellRenderer;
import DAL.TModelListener;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
public class prueba {

	private JFrame frame;
	private JTable tablePrueba;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba window = new prueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public prueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 660, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
		);
		
		
		tablePrueba = new JTable();
		/*
		tablePrueba.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		*/

		
		tablePrueba.setModel(new TModel(
				new Object[][] {
					{null},
					{null},
				},
				new String[] { "Nombre", "Apellido Paterno", "Apellido Materno","Nota 1", "Nota 2", "Nota 3", "Nota Final"}	)
				);
		
		tablePrueba.getModel().addTableModelListener(new TModelListener());
		tablePrueba.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
		
		scrollPane.setViewportView(tablePrueba);
		frame.getContentPane().setLayout(groupLayout);
	}
}
