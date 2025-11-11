package Simulacion.Repositorios;

import java.util.ArrayList;
import java.util.List;

import Simulacion.Modelos.CentroLogistico;
import Simulacion.Modelos.Trabajador;
import Simulacion.Utilidades.BancoException;

public class RepositorioCentro {

	List <CentroLogistico> centros;

	public RepositorioCentro() {
		super();
		this.centros = new ArrayList<>();
	}
	
	public void agregarCentro (CentroLogistico c) throws BancoException {
		for (CentroLogistico centro : centros) {
			if (centro.getId().equalsIgnoreCase(c.getId())) {
				throw new BancoException("Ya existe el id asociado a un centro");
			} else {
				centros.add(c);			}
		}
	}
	public void agregarTrabajadoraCentro (Trabajador c) throws BancoException {
		for (CentroLogistico centro : centros) {
			if (centro.getPersonal().contains(c)) {
				throw new BancoException("Ya existe el trabajador asociado a un centro");
			} else {
				centro.getPersonal().add(c);			}
		}
	}
	
	public CentroLogistico getCentroLogistico(CentroLogistico c) {
		for (CentroLogistico centro : centros) {
			if (centro.getId().equalsIgnoreCase(c.getId())){
			}
		}return c;
	}
	public Trabajador getTrabajador(Trabajador t) {
		for (CentroLogistico centro : centros) {
			if (centro.getPersonal().contains(t.getDni())){
			}
		}return t;
	}
	
	
}
