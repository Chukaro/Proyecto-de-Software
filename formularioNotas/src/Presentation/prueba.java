package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import DAL.TModel;
import DAL.CellRenderer;
import DAL.TModelListener;
public class prueba {

	private JFrame frame;
	private JTable tablePrueba;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
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
				new String[] { "Producto", "Valor editable", "Valor Fijo","Total" }	)
				);
		
		tablePrueba.getModel().addTableModelListener(new TModelListener());
		tablePrueba.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
		
		scrollPane.setViewportView(tablePrueba);
		frame.getContentPane().setLayout(groupLayout);
	}
}
