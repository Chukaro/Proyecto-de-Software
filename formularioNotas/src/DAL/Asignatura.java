package DAL;

public class Asignatura {

	private int idAsignatura;
	private String codAsignatura;
	private String nombre;
	private int aula;
	private int eliminado;
	
	public int getIdAsignatura() {
		return idAsignatura;
	}
	
	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}
	
	public String getCodAsignatura() {
		return codAsignatura;
	}
	
	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getAula() {
		return aula;
	}
	
	public void setAula(int aula) {
		this.aula = aula;
	}
	
	public int getEliminado() {
		return eliminado;
	}
	
	public void setEliminado(int eliminado) {
		this.eliminado = eliminado;
	}
	
	@Override
	public String toString()
	{
		return this.nombre;
	}
}
