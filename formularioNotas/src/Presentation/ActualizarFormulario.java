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
import java.awt.Font;

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
	
	private JLabel lblidMat;
	private JLabel lblIdfromulario;  
	private JLabel lblCodMat;
	private JLabel lblNombreDocente;
	private JLabel lblNomMat;
	
	public ActualizarFormulario() {
		setBorder(null);
		setBounds(100, 100, 800, 573);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 770, 146);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre materia");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 124, 14);
		panel.add(lblNewLabel);
		
		lblNomMat = new JLabel("New label");
		lblNomMat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomMat.setBounds(144, 11, 157, 14);
		panel.add(lblNomMat);
		
		JLabel lblNewLabel_2 = new JLabel("Semestre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 56, 88, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("I");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(144, 56, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre docente");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(378, 11, 120, 14);
		panel.add(lblNewLabel_4);
		
		lblNombreDocente = new JLabel("New label");
		lblNombreDocente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreDocente.setBounds(508, 11, 149, 14);
		panel.add(lblNombreDocente);
		
		JLabel lblNewLabel_6 = new JLabel("Codigo materia");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(378, 56, 120, 14);
		panel.add(lblNewLabel_6);
		
		lblCodMat = new JLabel("New label");
		lblCodMat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodMat.setBounds(508, 56, 149, 14);
		panel.add(lblCodMat);
		
		JLabel lblNewLabel_8 = new JLabel("Gestion");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 105, 46, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("2015");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(144, 105, 46, 14);
		panel.add(lblNewLabel_9);
		
		lblidMat = new JLabel("id materia");
		lblidMat.setBounds(235, 121, 66, 14);
		panel.add(lblidMat);
		
		
		
		lblIdfromulario = new JLabel("idFromulario");
		lblIdfromulario.setBounds(306, 121, 82, 14);
		panel.add(lblIdfromulario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 168, 740, 379);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 760, 447);
		
		
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
		table.setFont(new java.awt.Font("Tahoma", 0, 15));;
	}
	
	private void tamCelda(){
		int[] tamCel = {0, 190, 120, 120, 50, 50, 50, 70, 90}; 
		
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
		
	public void datosFormulario(int idMateria, int idDocente, String nomMat, String codMat, int idMat){
		DAL.Formulario formulario = BRL.FormularioBRL.RecuperarDatosActualizar(idMateria, idDocente);
		
		DAL.TModel modelo = (DAL.TModel) table.getModel();
		
		if(formulario.getSimple().size() != 0){
			
			for (DAL.DetalleFormularioSimple item : formulario.getSimple()) {
				
				
				Object [] fila = { item.getEstudiante().getId(), item.getEstudiante().getNombre(), item.getEstudiante().getPaterno(), item.getEstudiante().getMaterno(), item.getNota1(), item.getNota2(), item.getNota3(), null, null };
				modelo.addRow(fila);
			}
		
		}
		
		//datos de los labels
		lblidMat.setText(idMat+"");
		lblIdfromulario.setText(formulario.getId()+"");  
		lblCodMat.setText(codMat);
		lblNombreDocente.setText(Main.Main.getNombre());		
		lblNomMat.setText(nomMat);
		
	}
}
