package BRL;

public class FormularioBRL {
	public static DAL.Formulario RecuperarDatosActualizar( int idMateria, int idDocente){
		return DAL.Formulario.recuperarDatosActualizar(idMateria, idDocente);
	}
}
