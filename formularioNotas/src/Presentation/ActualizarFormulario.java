package Presentation;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class ActualizarFormulario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	private JTable table;
	private JComponent barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarra = null; 
	
	public ActualizarFormulario() {
		setBorder(null);
		setBounds(100, 100, 801, 573);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 778, 146);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre materia");
		lblNewLabel.setBounds(10, 11, 98, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(144, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Semestre");
		lblNewLabel_2.setBounds(10, 56, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("I");
		lblNewLabel_3.setBounds(144, 56, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre docente");
		lblNewLabel_4.setBounds(378, 11, 90, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(508, 11, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Codigo docente");
		lblNewLabel_6.setBounds(378, 56, 90, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(508, 56, 46, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Gestion");
		lblNewLabel_8.setBounds(10, 105, 46, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("2015");
		lblNewLabel_9.setBounds(144, 105, 46, 14);
		panel.add(lblNewLabel_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 168, 780, 379);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 780, 447);
		
		
		table = new JTable();
		table.setModel(new DAL.TModel(
			new Object[0][0],
			new String[] {
				"N\u00BA", "Nombre", "Paterno", "Materno", "Nota 1", "Nota 2", "Nota 3", "Promedio", "Observacion"
			}
		));
		
		table.getModel().addTableModelListener( new DAL.TModelListener() );
		scrollPane.setViewportView(table);
		panel_1.add(scrollPane);
		
		tamCelda();
		quitarBarraTitulo();
	}
	
	private void tamCelda(){
		int[] tamCel = {0, 190, 120, 120, 50, 50, 50, 70, 100}; 
		
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setMaxWidth(tamCel[i]);

			table.getColumnModel().getColumn(i).setMinWidth(tamCel[i]);

			table.getColumnModel().getColumn(i).setPreferredWidth(tamCel[i]);
		}
	}
	
	public void quitarBarraTitulo(){ 
		barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
		DimensionBarra = barra.getPreferredSize(); 
		barra.setSize(0,0); 
		barra.setPreferredSize(new Dimension(0,0)); 
		repaint(); 
	}
		
	public void datosFormulario(int idMateria, int idDocente){
		DAL.Formulario formulario = BRL.FormularioBRL.recuperarDatosActualizar(idDocente, idMateria);
		
		DAL.TModel modelo = (DAL.TModel) table.getModel();
		
		if(formulario.getSimple().size() != 0){
			
			for (DAL.DetalleFormularioSimple item : formulario.getSimple()) {
				
				
				Object [] fila = { item.getEstudiante().getId(), item.getEstudiante().getNombre(), item.getEstudiante().getPaterno(), item.getEstudiante().getMaterno(), item.getNota1(), item.getNota2(), item.getNota3(), null, null };
				modelo.addRow(fila);
			}
		
		}
	}
	
}
