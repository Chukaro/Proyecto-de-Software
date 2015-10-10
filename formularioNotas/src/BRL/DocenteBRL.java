package BRL;

import java.util.List;

public class DocenteBRL {
	
	public static List<DAL.Docente> Docentes()
	{
		return DAL.Docente.docentes();
	}
	
	public static DAL.Docente InformacionDocente(int idDoc)
	{
		return DAL.Docente.informacionDocente(idDoc);		
	}
}
