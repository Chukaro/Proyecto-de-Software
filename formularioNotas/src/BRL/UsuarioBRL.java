package BRL;

public class UsuarioBRL {
	
	public static int VerficaUser(String nom, String pass){
		return DAL.Usuario.verificaUser(nom, pass);
	}
	
	public static boolean ExisteUsuario(String nom){
		return DAL.Usuario.existeNombreUsuario(nom);
	}
	
	public static void CrearUsuario(String usuario, String pass, int idDoc)
	{
		DAL.Usuario.crearUsuario(pass, usuario, idDoc);
	}

}
