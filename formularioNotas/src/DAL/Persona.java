package DAL;

public class Persona {

	private int id;
	private String nombre;
	private String paterno;
	private String materno;
	private int codEst;
	private int eliminado;
	
	public Persona() {
		
	}

	public int getCodEst() {
		return codEst;
	}

	public void setCodEst(int codEst) {
		this.codEst = codEst;
	}

	public int getEliminado() {
		return eliminado;
	}

	public void setEliminado(int eliminado) {
		this.eliminado = eliminado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}
	
	@Override
	public String toString()
	{
		return this.nombre;
	}
	
}
