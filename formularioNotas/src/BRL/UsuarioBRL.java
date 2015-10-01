package BRL;

public class UsuarioBRL {
	
	public static boolean VerficaUser(String nom, String pass){
		return DAL.Usuario.verificaUser(nom, pass);
	}
	
	public static boolean ExisteUsuario(String nom){
		return DAL.Usuario.existeNombreUsuario(nom);
	}

}
