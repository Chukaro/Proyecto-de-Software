package Presentation;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanillaSimple extends JInternalFrame {

	//objetos necesarios para quitar el titulo del JInternalFrame
	private JComponent barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarra = null; 
	private JTable table;
	
	private JLabel lblGes;
	private JLabel lblNomMat;
	private JLabel lblSem;
	private JLabel lblDocente;
	private JLabel lblCodAsig;
	
	public PanillaSimple() {
		setBorder(null);
		setResizable(true);
		setBounds(100, 100, 787, 431);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 767, 255);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setBounds(10, 11, 71, 14);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setBounds(10, 86, 71, 14);
		
		JLabel lblNewLabel = new JLabel("Docente:");
		lblNewLabel.setBounds(325, 22, 69, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion:");
		lblNewLabel_1.setBounds(325, 75, 71, 14);
		
		lblNomMat = new JLabel("New label");
		lblNomMat.setBounds(91, 11, 177, 14);
		
		lblSem = new JLabel("New label");
		lblSem.setBounds(92, 86, 109, 14);
		
		lblDocente = new JLabel("New label");
		lblDocente.setBounds(404, 22, 160, 14);
		
		lblGes = new JLabel("New label");
		lblGes.setBounds(406, 75, 89, 14);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(598, 11, 86, 107);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\MIGUEL\\git\\Proyecto-de-Software\\Proyecto-de-Software\\Proyecto-de-Software\\Proyecto-de-Software\\formularioNotas\\src\\Imagenes\\logocrg.gif"));
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DAL.TModel(
			new Object[0][0],
			new String[] {
				"N\u00BA", "Nombre", "Paterno", "Materno", "Nota 1", "Nota 2", "Nota 3", "Promedio", "Observacion"
			}
		));
		
		table.getModel().addTableModelListener( new DAL.TModelListener() );
		
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(lblGes);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblDocente);
		getContentPane().add(lblSemestre);
		getContentPane().add(lblSem);
		getContentPane().add(lblMateria);
		getContentPane().add(lblNomMat);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblCodigo = new JLabel("New label");
		lblCodigo.setBounds(10, 49, 46, 14);
		getContentPane().add(lblCodigo);
		
		lblCodAsig = new JLabel("New label");
		lblCodAsig.setBounds(90, 49, 111, 14);
		getContentPane().add(lblCodAsig);
		quitarBarraTitulo();
	
	}
	//quita la barra de titulo
	public void quitarBarraTitulo(){ 
		barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
		DimensionBarra = barra.getPreferredSize(); 
		barra.setSize(0,0); 
		barra.setPreferredSize(new Dimension(0,0)); 
		repaint(); 
	}
	
	public void datosTabla(int idMateria){
		List<DAL.Estudiante> lista = DAL.Estudiante.datosTabla(idMateria);
		
		DAL.TModel modelo = (DAL.TModel) table.getModel();
		
		if(lista.size() != 0){
			
			for (DAL.Estudiante item : lista) {
				Object [] fila = { item.getId(), item.getNombre(), item.getPaterno(), item.getMaterno(), 0, 0, 0, null, null };
				modelo.addRow(fila);
			}
		
		}
	}
	
	public void datosLabel(String nomDocente, String materia, String cod){
		lblDocente.setText(nomDocente);		
		lblCodAsig.setText(cod);
		lblNomMat.setText(materia);
	}
}
