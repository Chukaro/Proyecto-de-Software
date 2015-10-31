package BRL;

public class FormularioBRL {
	public static DAL.Formulario RecuperarDatosActualizar( int idMateria, int idDocente){
		return DAL.Formulario.recuperarDatosActualizar(idMateria, idDocente);
	}
	public static void ActualizarDatosFormularioSimple(DAL.Formulario actualizar){
		DAL.Formulario.actualizarDatosFormularioSimple(actualizar);
	}
}
