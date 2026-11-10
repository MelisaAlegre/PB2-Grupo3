package unlam_tpPB2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class RefugioTest {

	private Refugio refugio;
	private Perro perro;
	private Perro perro2;
	private Gato gato;
	private Gato gato2;
	private Adoptante adoptante;
	private Adoptante adoptanteRepetido;
	private Adoptante adoptante2;
	private Adoptante adoptante3;
	
	@Before
	public void setUp(){
		
		refugio = new Refugio("Refugio Patitas");
		perro = new Perro ("A23", "Lolo", 4, 5.2, Estado.ADOPTADO, Tamanio.MEDIANO, true);
		perro2 = new Perro ("A45", "Mora", 2, 3.1, Estado.DISPONIBLE, Tamanio.MEDIANO, true);
		gato = new Gato ("F11", "Pipa", 1, 2.7, Estado.DISPONIBLE, TipoPelaje.CORTO, true);
		adoptante = new Adoptante(3636336, "Sabrina", 1109091234, "San Martin 389",TipoVivienda.CASA,true,true);
		adoptanteRepetido = new Adoptante(3636336, "Sabrina", 1109091234, "San Martin 389",TipoVivienda.CASA,true,true);
		gato2 = new Gato ("F22", "Vainilla", 5, 6.0, Estado.DISPONIBLE, TipoPelaje.CORTO, true);
		adoptante2 = new Adoptante(9087653, "Gladys", 1109343434, "Belgrano 90", TipoVivienda.DEPARTAMENTO,true,true);
		adoptante3 = new Adoptante(4527120, "Agustin", 1122442321, "Rivadavia 2354", TipoVivienda.DEPARTAMENTO,false,true);
		
		
	}
	

	@Test (expected = AnimalNoDisponibleException.class)
		
		public void intentarRegistrarAnimalAdoptadoAnimalNoDisponibleException() throws AnimalNoDisponibleException {
			
			refugio.agregarAnimal(perro);
			refugio.agregarAdoptante(adoptante);
			
			SolicitudAdopcion nuevaSolicitud = new SolicitudAdopcion(3, LocalDate.of(2026, 11, 7), adoptante, perro);
			
			refugio.registrarSolicitud(nuevaSolicitud);
			
		}
	@Test
	public void registrarYBuscarAdoptantePorDniExistente() {
		Adoptante nuevoAdoptante=new Adoptante(46022185, "Karen", 1144661546, "Roma 55",TipoVivienda.CASA, true, true);
		refugio.agregarAdoptante(nuevoAdoptante);
		
		Adoptante adoptanteEncontrado= refugio.buscarAdoptantePorDni(nuevoAdoptante);
		assertEquals(46022185, adoptanteEncontrado.getDni(),0.0);
		
		
	}
		
	@Test
	public void registrarYBuscarAnimalPorCodigoExistosamente() {
		Animal nuevoPerro = new Perro ("A50", "Mara", 8, 3.7, Estado.DISPONIBLE, Tamanio.PEQUEÑO, true);
		refugio.agregarAnimal(nuevoPerro);
		
		Animal animalEncontrado= refugio.buscarAnimalPorCodigo(nuevoPerro);
		assertEquals("A50", animalEncontrado.getCodigoAnimal());
	}
	
	@Test(expected = AdoptanteDuplicadoException.class)
	
	public void noPermitirAdoptanteDuplicado() throws AdoptanteDuplicadoException {
		Adoptante nuevoAdoptante=new Adoptante(9087653, "Mara", 1144661546, "Roma 55",TipoVivienda.CASA, true, true);
		refugio.registrarAdoptante(nuevoAdoptante);
		refugio.registrarAdoptante(adoptante2);
		
		
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
	public void crearSolicitudDeAdopcionYRegistrarEnLaLista()  throws AnimalNoDisponibleException {
		
		refugio.agregarAnimal(gato);
		refugio.agregarAdoptante(adoptante2);
		
		SolicitudAdopcion nuevaSolicitud = new SolicitudAdopcion(1, LocalDate.of(2026, 11, 9), adoptante2, gato);
		
		refugio.registrarSolicitud(nuevaSolicitud);
		
		assertEquals(1, refugio.getSolicitudes().size());
		assertEquals(1, refugio.getSolicitudes().first().getIdSolicitud(), 0.0);
	}
	
	@Test
	public void concretarAdopcionExitosaYCambiarEstado() throws AnimalNoDisponibleException  {
		
		refugio.agregarAnimal(perro2);
		refugio.agregarAdoptante(adoptante);
		
		SolicitudAdopcion nuevaSolicitud = new SolicitudAdopcion(5, LocalDate.of(2026, 11, 9), adoptante, perro2);
		
		refugio.registrarSolicitud(nuevaSolicitud);
		
		Boolean seConcreto = refugio.concretarAdopcion(nuevaSolicitud);
		
		assertEquals(Estado.ADOPTADO, perro2.getEstado());
		assertTrue(seConcreto);
		
	}
	
	@Test
	public void rechazoAdopcionPerroSinPatio()  throws AnimalNoDisponibleException {
		
		refugio.agregarAnimal(perro2);
		refugio.agregarAdoptante(adoptante3);
		
		SolicitudAdopcion nuevaSolicitud = new SolicitudAdopcion(1, LocalDate.of(2026, 11, 9), adoptante3, perro2);
		
		refugio.registrarSolicitud(nuevaSolicitud);
		
		Boolean seRechazoLaSolicitud = refugio.evaluaLosRequisitosDeAdopcion(nuevaSolicitud);
		
		assertFalse(seRechazoLaSolicitud);
		
		
	}
	
	@Test (expected = AnimalNoDisponibleException.class)
	public void evitarSolicitudDuplicadaParaElMismoAnimal() throws AnimalNoDisponibleException {
		
		refugio.agregarAnimal(gato);
		refugio.agregarAdoptante(adoptante);
		refugio.agregarAdoptante(adoptanteRepetido);
		
		SolicitudAdopcion nuevaSolicitud = new SolicitudAdopcion(3, LocalDate.of(2026, 11, 7), adoptante, gato);
		SolicitudAdopcion nuevaSolicitud2 = new SolicitudAdopcion(5, LocalDate.of(2026, 11, 9), adoptanteRepetido, gato);
		
		refugio.registrarSolicitud(nuevaSolicitud);
		refugio.registrarSolicitud(nuevaSolicitud2);
		
		
	}
	
	@Test
	public void validarCumplimientoDeRequisitosDeAdopcion() throws AnimalNoDisponibleException {
		refugio.agregarAnimal(perro2);
		refugio.agregarAdoptante(adoptante);
		
		SolicitudAdopcion nuevaSolicitud = new SolicitudAdopcion(7, LocalDate.of(2026, 11, 9), adoptante, perro2);
		refugio.registrarSolicitud(nuevaSolicitud);
		
		boolean cumpleRequisitos = refugio.evaluaLosRequisitosDeAdopcion(nuevaSolicitud);
		assertTrue(cumpleRequisitos);
		
	}
	
	@Test
	public void cumplimientoRequisitosAdopcionConPerroConPatio() {
		
	}
	
	@Test
	public void rechazoAdopcionGatoConRestriccionDeMascotas() {
		
	}
	
	



	
	
}
