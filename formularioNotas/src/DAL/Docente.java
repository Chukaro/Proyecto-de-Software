package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Docente extends Persona{
	
	private String codDocente;
	private List<Asignatura> materias;
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Docente()
	{
		materias = new ArrayList<Asignatura>();
		usuario = new Usuario();
	}
	
	public String getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(String codDocente) {
		this.codDocente = codDocente;
	}

	public List<Asignatura> getMaterias() {
		return materias;
	}

	public void setMaterias(Asignatura a) {
		this.materias.add(a);
	}
	
	

	public static List<Docente> docentes()
	{
		List<Docente> retorno = new ArrayList<Docente>();
		Conextion con = Conextion.getConexion();
				
		String consulta = "select idDocente, CONCAT(nombre,' ',apPat,' ', apMAt) as nombre, codDocente "
				          + "from docente ORDER BY nombre ASC ";
		con.setConsulta(consulta);
		con.consultar();
		
		try {
			while(con.getListaResultado().next())
			{
				Docente lista = new Docente();
				
				lista.setId(con.getListaResultado().getInt("idDocente"));
				lista.setNombre(con.getListaResultado().getString("nombre"));
				lista.setCodDocente(con.getListaResultado().getString("codDocente"));
				
				retorno.add(lista);
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return retorno;
	}
	
	public static Docente informacionDocente(int idDoc)
	{
		Docente infDocente = new Docente();
		
		Conextion con = Conextion.getConexion();
		
		String consulta = "SELECT idDocente, CONCAT(d.nombre,' ',d.apPat) AS nombre, u.cargo FROM docente as d, usuario as u WHERE u.Docente_idDocente = d.idDocente and d.idDocente = "+ idDoc;
		con.setConsulta(consulta);
		con.consultar();
		
		try {
			
			if(con.getListaResultado().first())
			{
				Usuario userDoc = new Usuario();
				
				infDocente.setId(con.getListaResultado().getInt("idDocente"));
				infDocente.setNombre(con.getListaResultado().getString("nombre"));
				
				userDoc.setCargo(con.getListaResultado().getString("cargo"));
				
				infDocente.setUsuario(userDoc);
				
				consulta = "SELECT a.idAsignatura, a.codAsignatura, a.nombre "
						+ "FROM asignatura as a, materiadocente as md "
						+ "WHERE md.Asingantura_idAsignatura = a.idAsignatura "
						+ "and md.Asingantura_idAsignatura NOT IN (SELECT MateriaDocente_Asingantura_idAsignatura FROM formularionotas) "
						+ "and md.Docente_idDocente = "+ idDoc;
			
				con.setConsulta(consulta);
				con.consultar();
			
				while (con.getListaResultado().next())
				{
					Asignatura materia = new Asignatura();	
				
					materia.setIdAsignatura(con.getListaResultado().getInt("idAsignatura"));	
					materia.setCodAsignatura(con.getListaResultado().getString("codAsignatura"));
					materia.setNombre(con.getListaResultado().getString("nombre"));
				
					infDocente.setMaterias(materia);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return infDocente;
	}
	
	public static List<Asignatura> materiaFormulario(int idDoc){
		
		List<Asignatura> dev = new ArrayList<Asignatura>();
		
		Conextion con = Conextion.getConexion();
		
		String consulta = "SELECT a.idAsignatura, a.codAsignatura, a.nombre "
				+ "FROM asignatura as a, materiadocente as md "
				+ "WHERE md.Asingantura_idAsignatura = a.idAsignatura "
				+ "and md.Asingantura_idAsignatura IN (SELECT MateriaDocente_Asingantura_idAsignatura FROM formularionotas) "
				+ "and md.Docente_idDocente ="+ idDoc;
		
		con.setConsulta(consulta);
		con.consultar();
		
		try {
			while (con.getListaResultado().next())
			{
				Asignatura materia = new Asignatura();	
			
				materia.setIdAsignatura(con.getListaResultado().getInt("idAsignatura"));	
				materia.setCodAsignatura(con.getListaResultado().getString("codAsignatura"));
				materia.setNombre(con.getListaResultado().getString("nombre"));
			
				dev.add(materia);
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dev;
	}
}
