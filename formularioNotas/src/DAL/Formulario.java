package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Formulario {

	private int id;
	private int notaMax;
	private int notaMin;
	private int idMateria;
	private int idDocente;
	
	private List<DetalleFormularioSimple> simple = new ArrayList<DetalleFormularioSimple>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNotaMax() {
		return notaMax;
	}

	public void setNotaMax(int notaMax) {
		this.notaMax = notaMax;
	}

	public int getNotaMin() {
		return notaMin;
	}

	public void setNotaMin(int notaMin) {
		this.notaMin = notaMin;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public List<DetalleFormularioSimple> getSimple() {
		return simple;
	}

	public void setSimpel(DetalleFormularioSimple detalle) {
		simple.add(detalle);
	}

	public static void grabarFormulario(Formulario formulario){
		
		Conextion con = Conextion.getConexion();
				
		String consulta = "INSERT INTO formularionotas (notaMaxima, notaMinima, MateriaDocente_Asingantura_idAsignatura, MateriaDocente_Docente_idDocente)";
		consulta += " VALUES (1, 1, 1, 1)";
		con.setConsulta(consulta);
		
		con.consultar();
		
		int valor = con.ejecutar();
		
		if (valor > 0) {
			consulta = "SELECT MAX(idFormulario) AS id FROM formularionotas";
			con.setConsulta(consulta);
			
			con.consultar();
			try {
				while (con.getListaResultado().next()) {
					formulario.setId(con.getListaResultado().getInt("id"));
					
					for (DetalleFormularioSimple item : formulario.getSimple()) {
						consulta = "INSERT INTO detalleformulariosimple"
								+ "(parcialUno, parcialDos, parcialTres, FormularioNotas_idFormulario, MateriaAlumno_Estudiante_idEstudiante, MateriaAlumno_Asingantura_idAsignatura)"
								+ "VALUES (1, 1, 1, 1, 1, 1)";
						con.setConsulta(consulta);
						
						con.consultar();
					}
					
				}				
			}  catch (SQLException e) {
				e.printStackTrace();
			}
	
		}	
		
	}
}
