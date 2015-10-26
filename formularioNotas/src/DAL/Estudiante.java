package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Estudiante extends Persona{
	
	public static List<Estudiante> datosTabla(int idMateria)
	{
		List<Estudiante> datos = new ArrayList<Estudiante>();
		
		Conextion con = Conextion.getConexion();
		
		String consulta = "SELECT e.idEstudiante, e.nombre, e.apPat, e.apMat FROM estudiante e, materiaalumno ma WHERE e.idEstudiante = ma.Estudiante_idEstudiante AND Asingantura_idAsignatura = "+idMateria+" order by e.apPat";
		con.setConsulta(consulta);
		con.consultar();
		
		try {
			while(con.getListaResultado().next())
			{
				Estudiante est = new Estudiante();
				
				est.setId(con.getListaResultado().getInt("idEstudiante") );
				est.setNombre(con.getListaResultado().getString("nombre"));
				est.setPaterno(con.getListaResultado().getString("apPat"));
				est.setMaterno(con.getListaResultado().getString("apMat"));
				
				datos.add(est);
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datos;
	}

}
