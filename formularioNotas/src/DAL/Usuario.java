package DAL;

import java.sql.SQLException;

import Presentation.Inicio;

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
	
	public static int verificaUser(String usuario, String pass){
		
		Conextion con = Conextion.getConexion();
				
		int idDocente = 0;
		
		String consulta = "select Docente_idDocente from usuario where usuario = '"+usuario+"' and password = '"+pass+"'";
		con.setConsulta(consulta);
		con.consultar();
		
		try {
			while(con.getListaResultado().next())
			{
				idDocente = con.getListaResultado().getInt("Docente_idDocente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return idDocente;
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
		boolean verfica = false;
		
		String consulta = "INSERT INTO usuario (idUsuario, usuario, password, eliminado, Docente_idDocente, cargo) VALUES (NULL, '"+usuario+"', '"+pass+"', b'1',"+idDocente+",'"+cargo+"' );";
		
		con.setConsulta(consulta);
		
		con.ejecutar();
	}
	
}
