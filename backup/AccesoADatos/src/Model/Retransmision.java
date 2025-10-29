package Model;

import java.time.LocalDate;
import java.util.Objects;

public class Retransmision {

	private int idRetransmision;
	private Canal idCanal;
	private String titulo;
	private LocalDate fecha_inicio;
	private double duracion;

	public Retransmision(int idRetransmision, Canal idCanal, String titulo, LocalDate fecha_inicio, double duracion) {
		super();
		this.idRetransmision = idRetransmision;
		this.idCanal = idCanal;
		this.titulo = titulo;
		this.fecha_inicio = fecha_inicio;
		this.duracion = duracion;
	}

	public int getIdRetransmision() {
		return idRetransmision;
	}

	public void setIdRetransmision(int idRetransmision) {
		this.idRetransmision = idRetransmision;
	}

	public Canal getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(Canal idCanal) {
		this.idCanal = idCanal;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRetransmision);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retransmision other = (Retransmision) obj;
		return idRetransmision == other.idRetransmision;
	}

	@Override
	public String toString() {
		return "Retransmision [idRetransmision=" + idRetransmision + ", idCanal=" + idCanal + ", titulo=" + titulo
				+ ", fecha_inicio=" + fecha_inicio + ", duracion=" + duracion + "]";
	}

}
