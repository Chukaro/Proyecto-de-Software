package Presentation;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import DAL.DetalleFormularioSimple;
import DAL.Formulario;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

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
	private JLabel lblIdMat;
	
	
	
	public PanillaSimple() {
		
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setResizable(false);
		setBounds(100, 100, 774, 639);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 750, 447);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setBounds(10, 22, 71, 14);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setBounds(10, 97, 71, 14);
		
		JLabel lblNewLabel = new JLabel("Docente:");
		lblNewLabel.setBounds(325, 22, 69, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion:");
		lblNewLabel_1.setBounds(325, 75, 71, 14);
		
		lblNomMat = new JLabel("New label");
		lblNomMat.setBounds(129, 22, 177, 14);
		
		lblSem = new JLabel("I");
		lblSem.setBounds(129, 86, 26, 14);
		
		lblDocente = new JLabel("New label");
		lblDocente.setBounds(404, 22, 160, 14);
		
		lblGes = new JLabel("2015");
		lblGes.setBounds(406, 75, 89, 14);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(600, 11, 177, 61);
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
		
		JLabel lblCodigo = new JLabel("Codigo materia");
		lblCodigo.setBounds(10, 60, 89, 14);
		getContentPane().add(lblCodigo);
		
		lblCodAsig = new JLabel("New label");
		lblCodAsig.setBounds(129, 60, 111, 14);
		getContentPane().add(lblCodAsig);
		
		JButton btnGuardar = new JButton("Guardar Formulario");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DAL.Formulario entrada = new Formulario();
				//guardar los datos de la tabla y enviarlos a la base de datos
				
				entrada.setIdDocente(Main.Main.getIdDocente());
				entrada.setIdMateria(Integer.parseInt(lblIdMat.getText()));
				entrada.setNotaMax(100);
				entrada.setNotaMin(0);
				
				TableModel valores = table.getModel();

                int cols = valores.getColumnCount();
                int fils = valores.getRowCount();

                for (int i = 0; i < fils; i++) {
                	
                	Object[] fila = new Object[cols];
                    for (int j = 0; j < cols; j++) {

                        fila[j] = valores.getValueAt(i, j);
                    }
                                      
                    entrada.setSimpel(new DAL.DetalleFormularioSimple((int)fila[0], (int)fila[4], (int)fila[5], (int)fila[6], entrada.getIdMateria()));
                }
                
                DAL.Formulario.grabarFormulario(entrada);
                
			}
		});
		
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardar.setBounds(599, 112, 144, 29);
		getContentPane().add(btnGuardar);
		
		lblIdMat = new JLabel("idmat");
		lblIdMat.setBounds(322, 100, 26, 14);
		getContentPane().add(lblIdMat);
		quitarBarraTitulo();
		
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
		
		table.setFont(new java.awt.Font("Tahoma", 0, 15)); 
		tamCelda();
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
	
	public void datosLabel(String nomDocente, String materia, String cod, int idMat){
		lblDocente.setText(nomDocente);		
		lblCodAsig.setText(cod);
		lblNomMat.setText(materia);
		lblIdMat.setText(idMat+"");
		
	}
	
	private void tamCelda(){
		int[] tamCel = {0, 190, 120, 120, 50, 50, 50, 70, 100}; 
		
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setMaxWidth(tamCel[i]);

			table.getColumnModel().getColumn(i).setMinWidth(tamCel[i]);

			table.getColumnModel().getColumn(i).setPreferredWidth(tamCel[i]);
		}
	}
}
