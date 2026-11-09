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
	private TreeSet <SolicitudAdopcion> adopcionesExitosas;

	public Refugio(String nombre) {
		
		this.nombre = nombre;
		this.animales = new ArrayList<>();
		this.adoptantes = new HashMap<>();
		this.solicitudes = new TreeSet<>();
		this.adopcionesExitosas = new TreeSet<>();
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
	
	public void registrarAdoptante(Adoptante adoptante) throws AdoptanteDuplicadoException {
		if(this.adoptantes.containsKey(adoptante.getDni())) {
			throw new AdoptanteDuplicadoException ("El adoptante ya está registrado");
		}
		this.adoptantes.put(adoptante.getDni(), adoptante);
		
	}
	
	public void registrarSolicitud(SolicitudAdopcion solicitud) throws AnimalNoDisponibleException {
		
		Animal animal = solicitud.getAnimalSolicitado();
		
		if (animal.getEstado() != Estado.DISPONIBLE) {
			throw new AnimalNoDisponibleException("Este animal no se encuentra disponible");
		}
		
		
		this.solicitudes.add(solicitud);
		animal.setEstado(Estado.EN_PROCESO);
	}
	
	public Adoptante buscarAdoptantePorDni(Adoptante nuevoAdoptante) {
		// TODO Auto-generated method stub
		return this.adoptantes.get(nuevoAdoptante.getDni());
	}

	public Animal buscarAnimalPorCodigo(Animal nuevoPerro) {
		// TODO Auto-generated method stub
		for (Animal animal : animales) {
			if(animal.getCodigoAnimal().equals(nuevoPerro.getCodigoAnimal())) {
			return animal;
		}
		
	}
		return null;

	}

	public Boolean evaluaLosRequisitosDeAdopcion(SolicitudAdopcion solicitud) {
		
		Animal animal = solicitud.getAnimalSolicitado();
		Adoptante adoptante = solicitud.getAdoptante();
		
		return animal.cumpleRequisitosAdopcion(adoptante);
		
		
	}

	public Boolean concretarAdopcion(SolicitudAdopcion nuevaSolicitud) {

		Boolean seCumplio = evaluaLosRequisitosDeAdopcion(nuevaSolicitud);
		
		if(seCumplio) {
			Animal animal = nuevaSolicitud.getAnimalSolicitado();
			
			animal.setEstado(Estado.ADOPTADO);
		
			this.adopcionesExitosas.add(nuevaSolicitud);
			
			return true;
		}
		
		return false;
		
	}


}
