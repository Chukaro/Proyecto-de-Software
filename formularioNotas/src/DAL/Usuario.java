package DAL;

import java.sql.SQLException;

import Presentation.Inicio;

public class Usuario {
	private int id;
	private String usuario;
	private String password;
	
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
	
	public static boolean verificaUser(String usuario, String pass){
		
		Conextion con = Conextion.getConexion();
		boolean verfica = false;
		
		String consulta = "select * from usuario where usuario = '"+usuario+"' and password = '"+pass+"'";
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
	
	
	
}
