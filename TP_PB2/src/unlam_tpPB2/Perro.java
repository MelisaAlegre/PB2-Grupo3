package unlam_tpPB2;

public class Perro extends Animal{
	
	private Boolean requierePatio;
	private Tamanio tamanio;
	

	public Perro(String codigoAnimal, String nombre, Integer edadAproximada, double peso, Estado estado, Tamanio tamanio, Boolean requierePatio) {
		super(codigoAnimal, nombre, edadAproximada, peso, estado);
		this.tamanio = tamanio;
		this.requierePatio=requierePatio;	
	}


	


	public Boolean getRequierePatio() {
		return requierePatio;
	}





	public void setRequierePatio(Boolean requierePatio) {
		this.requierePatio = requierePatio;
	}





	public Tamanio getTamanio() {
		return tamanio;
	}


	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	
	
	
	
}
