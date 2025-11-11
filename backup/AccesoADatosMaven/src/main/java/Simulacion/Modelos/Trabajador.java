package Simulacion.Modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Trabajador {

	private String nombre;
	private String dni;
	private String fecha_nacimiento;
	private TipoPersonal tipo;
	private String id_centro;
	public Trabajador() {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.tipo = tipo;
		this.id_centro = id_centro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public TipoPersonal getTipo() {
		return tipo;
	}
	public void setTipo(TipoPersonal tipo) {
		this.tipo = tipo;
	}
	public String getId_centro() {
		return id_centro;
	}
	public void setId_centro(String id_centro) {
		this.id_centro = id_centro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		return Objects.equals(dni, other.dni);
	}
	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", dni=" + dni + ", fecha_nacimiento=" + fecha_nacimiento + ", tipo="
				+ tipo + ", id_centro=" + id_centro + "]";
	}
	
	
}
