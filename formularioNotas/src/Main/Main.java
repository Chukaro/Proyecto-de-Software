package Main;

import Presentation.Login;

public class Main {
	
	public static String nombre;
	// de esta variable puedes recuperar el id del docente
	//para hacer el update del usuario del password que no cambie su nombre de usuario
	//verificas que el nevo password lo abres en una ventana no dentro el desktops pane 
	//Main.Main.getIdDOcente()
	public static int idDocente;
	
	public static int getIdDocente() {
		return idDocente;
	}

	public static void setIdDocente(int idDocente) {
		Main.idDocente = idDocente;
	}

	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String nombre) {
		Main.nombre = nombre;
	}

	public static void main(String[] args) {
		//Se Inicia el programa
		Login window = new Login();
		window.getFrame().setVisible(true);
	}

}
