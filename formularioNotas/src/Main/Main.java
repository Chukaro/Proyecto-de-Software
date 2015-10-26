package Main;

import Presentation.Login;

public class Main {
	
	public static int idDocente;
	
	public static int getIdDocente() {
		return idDocente;
	}

	public static void setIdDocente(int idDocente) {
		Main.idDocente = idDocente;
	}

	
	public static void main(String[] args) {
		//Se Inicia el programa
		Login window = new Login();
		window.getFrame().setVisible(true);
	}

}
