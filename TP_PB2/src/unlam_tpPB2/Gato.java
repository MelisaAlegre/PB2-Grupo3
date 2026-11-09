package unlam_tpPB2;

public class Gato extends Animal {
	
	private TipoPelaje tipoPelaje;
	private boolean requiereHogarSinOtraMascota;
	
	
	public Gato(String codigoAnimal, String nombre, Integer edadAproximada, double peso, Estado estado, TipoPelaje tipoPelaje, boolean requiereHogarSinOtraMascota) {
		super(codigoAnimal, nombre, edadAproximada, peso, estado);
		this.tipoPelaje = tipoPelaje;
		this.requiereHogarSinOtraMascota=requiereHogarSinOtraMascota;
		
		
	}


	public TipoPelaje getTipoPelaje() {
		return tipoPelaje;
	}


	public void setTipoPelaje(TipoPelaje tipoPelaje) {
		this.tipoPelaje = tipoPelaje;
	}


	public boolean isRequiereHogarSinOtraMascota() {
		return requiereHogarSinOtraMascota;
	}


	public void setRequiereHogarSinOtraMascota(boolean requiereHogarSinOtraMascota) {
		this.requiereHogarSinOtraMascota = requiereHogarSinOtraMascota;
	}


	@Override
	public Boolean cumpleRequisitosAdopcion(Adoptante adoptante) {

		if(this.requiereHogarSinOtraMascota == adoptante.getTieneOtrasMascotas()) {
			return false;
		}
		return true;
		
	}


	
	
	
	
}
