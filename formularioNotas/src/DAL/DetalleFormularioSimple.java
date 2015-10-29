package DAL;

public class DetalleFormularioSimple {
	
	private int idDetFormulario;
	private int nota1;
	private int nota2;
	private int nota3;
	private int idFormulario;
	private int idEstudiante;
	private int idMateria;
	private String nomEst;
	private Estudiante estudiante;
	
	public Estudiante getEstudiante() {
		return estudiante;
	}

	
	
	public DetalleFormularioSimple(int idEstudiante, int nota1, int nota2, int nota3, int idMateria) {
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.idEstudiante = idEstudiante;
		this.idMateria = idMateria;
	}

    public String getNomEst() {
		return nomEst;
	}

	public void setNomEst(String nomEst) {
		this.nomEst = nomEst;
	}

	public int getIdDetFormulario() {
		return idDetFormulario;
	}
	public void setIdDetFormulario(int idDetFormulario) {
		this.idDetFormulario = idDetFormulario;
	}
	
	public int getNota1() {
		return nota1;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	
	public int getNota2() {
		return nota2;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	
	public int getNota3() {
		return nota3;
	}
	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}
	
	public int getIdFormulario() {
		return idFormulario;
	}
	public void setIdFormulario(int idFormulario) {
		this.idFormulario = idFormulario;
	}
	
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public DetalleFormularioSimple(){
		estudiante = new Estudiante();
	}
}
