package unlam_tpPB2;

import java.time.LocalDate;

public class SolicitudAdopcion implements Comparable <SolicitudAdopcion>{
	
	private Integer idSolicitud;
	private LocalDate fechaSolicitud;
	private Adoptante adoptante;
	private Animal animalSolicitado;
	
	
	public SolicitudAdopcion(Integer idSolicitud, LocalDate fechaSolicitud, Adoptante adoptante,
			Animal animalSolicitado) {
		this.idSolicitud = idSolicitud;
		this.fechaSolicitud = fechaSolicitud;
		this.adoptante = adoptante;
		this.animalSolicitado = animalSolicitado;
	}


	
	
	public Integer getIdSolicitud() {
		return idSolicitud;
	}


	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}


	public Adoptante getAdoptante() {
		return adoptante;
	}

	public Animal getAnimalSolicitado() {
		return animalSolicitado;
	}



	@Override
	public int compareTo(SolicitudAdopcion otraSolicitud) {
		int resultado = this.fechaSolicitud.compareTo(otraSolicitud.getFechaSolicitud());
		if (resultado == 0) {
			return this.idSolicitud.compareTo(otraSolicitud.getIdSolicitud());
		}
		return resultado;
	}
	
	

}
