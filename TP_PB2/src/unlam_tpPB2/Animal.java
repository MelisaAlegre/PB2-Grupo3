package unlam_tpPB2;

public abstract class Animal {

	private String codigoAnimal;
	private String nombre;
	private Integer edadAproximada;
	private double peso;
	private Estado estado;
	
	
	public Animal(String codigoAnimal, String nombre, Integer edadAproximada, double peso, Estado estado) {
		this.codigoAnimal = codigoAnimal;
		this.nombre = nombre;
		this.edadAproximada = edadAproximada;
		this.peso = peso;
		this.estado = estado;
	}


	public String getCodigoAnimal() {
		return codigoAnimal;
	}


	public void setCodigoAnimal(String codigoAnimal) {
		this.codigoAnimal = codigoAnimal;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getEdadAproximada() {
		return edadAproximada;
	}


	public void setEdadAproximada(Integer edadAproximada) {
		this.edadAproximada = edadAproximada;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
}
