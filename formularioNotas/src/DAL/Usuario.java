package DAL;

import java.sql.SQLException;

public class Usuario {
	private int id;
	private String usuario;
	private String password;
	private String cargo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public static String[] verificaUser(String usuario, String pass){
		
		Conextion con = Conextion.getConexion();
				
		String[] datos = new String[2];
		
		String consulta = "select u.Docente_idDocente, CONCAT(d.nombre,' ',d.apPat) as nombre "
				+ "from usuario as u, docente as d "
				+ "where d.idDocente = u.Docente_idDocente and usuario = '"+usuario+"' and password = '"+pass+"'";
		con.setConsulta(consulta);
		con.consultar();
		
		try {
			if(con.getListaResultado().last())
			{
				datos[0] = con.getListaResultado().getInt("Docente_idDocente") + "";
				datos[1] = con.getListaResultado().getString("nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return datos;
	}
	
	public static boolean existeNombreUsuario(String usuario)
	{
		Conextion con = Conextion.getConexion();
		boolean verfica = false;
		
		String consulta = "select * from usuario where usuario = '"+usuario+"'";
		con.setConsulta(consulta);
		con.consultar();
		
		try {
			if (con.getListaResultado().last()){
				verfica = true;
			}
			else{
				//JOptionPane.showMessageDialog(null, "No exsite el usuario","ERROR");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return verfica;
	}
	
	public static void crearUsuario(String pass, String usuario, int idDocente, String cargo)
	{
		Conextion con = Conextion.getConexion();
				
		String consulta = "INSERT INTO usuario (idUsuario, usuario, password, eliminado, Docente_idDocente, cargo) VALUES (NULL, '"+usuario+"', '"+pass+"', b'1',"+idDocente+",'"+cargo+"' );";
		
		con.setConsulta(consulta);
		
		con.ejecutar();
	}
	
}
