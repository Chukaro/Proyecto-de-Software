package BRL;

public class UsuarioBRL {
	
	public static boolean VerficaUser(String nom, String pass){
		return DAL.Usuario.verificaUser(nom, pass);
	}

}
