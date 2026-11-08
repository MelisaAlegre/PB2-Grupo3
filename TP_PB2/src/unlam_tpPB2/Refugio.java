package unlam_tpPB2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Refugio {

	private String nombre;
	private List <Animal> animales;
	private Map <Integer, Adoptante> adoptantes;
	private TreeSet <SolicitudAdopcion> solicitudes;

	public Refugio(String nombre) {
		
		this.nombre = nombre;
		this.animales = new ArrayList<>();
		this.adoptantes = new HashMap<>();
		this.solicitudes = new TreeSet<>();
	}

	public String getNombre() {
		return nombre;
		
	}
	

	public List<Animal> getAnimales() {
		return animales;
	}

	public Map<Integer, Adoptante> getAdoptantes() {
		return adoptantes;
	}

	public TreeSet<SolicitudAdopcion> getSolicitudes() {
		return solicitudes;
	}
	

	public void agregarAnimal(Animal animal) {
		
		this.animales.add(animal);
		
	}

	public void agregarAdoptante(Adoptante adoptante) {
		
		this.adoptantes.put(adoptante.getDni(), adoptante);
		
	}
	
	public void registrarSolicitud(SolicitudAdopcion solicitud) throws AnimalNoDisponibleException {
		
		Animal animal = solicitud.getAnimalSolicitado();
		
		if (animal.getEstado() != Estado.DISPONIBLE) {
			throw new AnimalNoDisponibleException("Este animal no se encuentra disponible");
		}
		
		
		this.solicitudes.add(solicitud);
	}



}
