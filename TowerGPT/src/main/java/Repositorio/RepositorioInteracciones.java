package Repositorio;

import java.util.ArrayList;

import Modelos.InteraccionAgente;

public class RepositorioInteracciones {
	 private ArrayList<InteraccionAgente> registro;

	    public RepositorioInteracciones() {
	        registro = new ArrayList<>();
	    }

	    public void agregaInteraccionARegistro(InteraccionAgente interaccion) {
	        registro.add(interaccion);
	    }

	    public void actualizaPorcentajeInteraccion(int id, double nuevoPorcentaje) {
	        for (InteraccionAgente i : registro) {
	            if (i.getIdentificador() == id) {
	                i.setPorcentajeAcierto(nuevoPorcentaje);
	            }
	        }
	    }

	    public void incrementaNumeroValoraciones(int id) {
	        for (InteraccionAgente i : registro) {
	            if (i.getIdentificador() == id) {
	                i.setNumValoracionesPositivas(i.getNumValoracionesPositivas() + 1);
	            }
	        }
	    }
	    
	    public void eliminarInteraccionPorId(int id) {
	        InteraccionAgente elimina = null;
	        for (InteraccionAgente i : registro) {
	            if (i.getIdentificador() == id) {
	            	elimina = i;
	                break;
	            }
	        }
	        if (elimina != null) {
	            registro.remove(elimina);
	        }
	    }

		public ArrayList<InteraccionAgente> getRegistro() {
			return registro;
		}

		public void setRegistro(ArrayList<InteraccionAgente> registro) {
			this.registro = registro;
		}

	    
	}
