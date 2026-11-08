package unlam_tpPB2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class RefugioTest {

	private Refugio refugio;
	private Perro perro;
	private Gato gato;
	private Gato gato2;
	private Adoptante adoptante;
	private Adoptante adoptante2;
	
	@Before
	public void setUp(){
		
		refugio = new Refugio("Refugio Patitas");
		perro = new Perro ("A23", "Lolo", 4, 5.2, Estado.ADOPTADO, Tamanio.MEDIANO, NivelEntrenamiento.BASICO);
		gato = new Gato ("F11", "Pipa", 1, 2.7, Estado.DISPONIBLE, TipoPelaje.CORTO, true);
		adoptante = new Adoptante(3636336, "Sabrina", 1109091234, "San Martin 389");
		gato2 = new Gato ("F22", "Vainilla", 5, 6.0, Estado.DISPONIBLE, TipoPelaje.CORTO, true);
		adoptante2 = new Adoptante(9087653, "Gladys", 1109343434, "Belgrano 90");
		
		
	}
	

	@Test (expected = AnimalNoDisponibleException.class)
		
		public void intentarRegistrarAnimalAdoptadoAnimalNoDisponibleException() throws AnimalNoDisponibleException {
			
			refugio.agregarAnimal(perro);
			refugio.agregarAdoptante(adoptante);
			
			SolicitudAdopcion nuevaSolicitud = new SolicitudAdopcion(3, LocalDate.of(2026, 11, 7), adoptante, perro);
			
			refugio.registrarSolicitud(nuevaSolicitud);
			
		}
		
	
	@Test
	public void ordenarPorFechaCronologicaSolicitudAdopcion() throws AnimalNoDisponibleException {

		refugio.agregarAnimal(gato);
		refugio.agregarAnimal(gato2);
		refugio.agregarAdoptante(adoptante);
		refugio.agregarAdoptante(adoptante2);
		LocalDate fechaHoy = LocalDate.of(2026, 11, 7);
		LocalDate fechaAyer = LocalDate.of(2026, 11, 6);
		
		
		SolicitudAdopcion nuevaSolicitud = new SolicitudAdopcion(3, fechaHoy, adoptante, gato);
		SolicitudAdopcion viejaSolicitud = new SolicitudAdopcion(10, fechaAyer, adoptante2, gato2);
		
		refugio.registrarSolicitud(nuevaSolicitud);
		refugio.registrarSolicitud(viejaSolicitud);
		
		TreeSet<SolicitudAdopcion> solicitudesOrdenadas = refugio.getSolicitudes();
		SolicitudAdopcion primeraSolicitud = solicitudesOrdenadas.first();
		
		assertEquals(fechaAyer, primeraSolicitud.getFechaSolicitud());
		
	}
	
	@Test
	public void validarAlmacenamientoCorrectoAdoptante() {
		
	}
	
	@Test
	public void verificaRealizarChequeoMedico() {
		
	}
	
	@Test
	public void intentarAdoptarAnimalNoDisposibleException() {
		
	}
	
	
	
}
