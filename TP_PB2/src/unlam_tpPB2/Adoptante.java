package unlam_tpPB2;

public class Adoptante {

	private Integer dni;
	private String nombre;
	private Integer telefono;
	private String direccion;
	private TipoVivienda tipoDeVivienda;
	private Boolean tienePatio;
	private Boolean tieneOtrasMascotas;
	
	public Adoptante(Integer dni, String nombre, Integer telefono, String direccion, TipoVivienda tipoDeVivienda, Boolean tienePatio, Boolean tieneOtrasMascotas) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipoDeVivienda=tipoDeVivienda;
		this.tienePatio=tienePatio;
		this.tieneOtrasMascotas=tieneOtrasMascotas;
	}
	

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}


	public TipoVivienda getTipoDeVivienda() {
		return tipoDeVivienda;
	}


	public Boolean getTienePatio() {
		return tienePatio;
	}


	public Boolean getTieneOtrasMascotas() {
		return tieneOtrasMascotas;
	}
	
	
	
	
	
	
	
}
