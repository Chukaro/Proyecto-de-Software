package BRL;

public class UsuarioBRL {
	
	public static String[] VerficaUser(String nom, String pass){
		return DAL.Usuario.verificaUser(nom, pass);
	}
	
	public static boolean ExisteUsuario(String nom){
		return DAL.Usuario.existeNombreUsuario(nom);
	}
	
	public static void CrearUsuario(String usuario, String pass, int idDoc, String cargo)
	{
		DAL.Usuario.crearUsuario(pass, usuario, idDoc, cargo);
	}

}
