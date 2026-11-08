package unlam_tpPB2;

public class Adoptante {

	private Integer dni;
	private String nombre;
	private Integer telefono;
	private String direccion;
	
	public Adoptante(Integer dni, String nombre, Integer telefono, String direccion) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
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
	
	
	
	
	
	
}
