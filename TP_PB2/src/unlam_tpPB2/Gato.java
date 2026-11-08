package unlam_tpPB2;

public class Gato extends Animal{
	
	private TipoPelaje tipoPelaje;
	private boolean aptoParaExterior;
	
	
	public Gato(String codigoAnimal, String nombre, Integer edadAproximada, double peso, Estado estado, TipoPelaje tipoPelaje, boolean AptoParaExterior) {
		super(codigoAnimal, nombre, edadAproximada, peso, estado);
		this.tipoPelaje = tipoPelaje;
		this.aptoParaExterior = false;
		
		
	}


	public TipoPelaje getTipoPelaje() {
		return tipoPelaje;
	}


	public void setTipoPelaje(TipoPelaje tipoPelaje) {
		this.tipoPelaje = tipoPelaje;
	}


	public boolean isAptoParaExterior() {
		return aptoParaExterior;
	}


	public void setAptoParaExterior(boolean aptoParaExterior) {
		this.aptoParaExterior = aptoParaExterior;
	}
	
	
	
	
	
}
