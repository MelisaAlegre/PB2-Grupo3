package unlam_tpPB2;

public class Perro extends Animal{
	
	private NivelEntrenamiento nivelEntrenamiento;
	private Tamanio tamanio;
	

	public Perro(String codigoAnimal, String nombre, Integer edadAproximada, double peso, Estado estado, Tamanio tamanio, NivelEntrenamiento nivelEntrenamiento) {
		super(codigoAnimal, nombre, edadAproximada, peso, estado);
		this.tamanio = tamanio;
		this.nivelEntrenamiento = nivelEntrenamiento;
		
	}


	public NivelEntrenamiento getNivelEntrenamiento() {
		return nivelEntrenamiento;
	}


	public void setNivelEntrenamiento(NivelEntrenamiento nivelEntrenamiento) {
		this.nivelEntrenamiento = nivelEntrenamiento;
	}


	public Tamanio getTamanio() {
		return tamanio;
	}


	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	
	
	
	
}
