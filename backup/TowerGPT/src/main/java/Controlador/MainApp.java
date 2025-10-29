package Controlador;

import java.io.IOException;
import java.util.ArrayList;

import Modelos.InteraccionAgente;
import Repositorio.RepositorioInteracciones;
import Servicios.ServicioEstadisticaImpl;

public class MainApp {

	public static void main(String[] args) {
		 try {
	            String rutaJson = "src/main/resources/interacciones.json";
	            ServicioEstadisticaImpl servicio = new ServicioEstadisticaImpl();
	            ArrayList<InteraccionAgente> interacciones = servicio.cargarRegistrosDesdeJSON(rutaJson);
	            System.out.println("Interacciones cargadas: " + interacciones.size());

	            RepositorioInteracciones repo = new RepositorioInteracciones();
	            for (InteraccionAgente i : interacciones) {
	                repo.agregaInteraccionARegistro(i);
	            }

	            InteraccionAgente mejor = servicio.obtenerInteraccionConMejorValoracion(interacciones);
	            System.out.println("\nInteracción con mejor valoración:");
	            System.out.println(mejor);

	            if (mejor != null) {
	                repo.actualizaPorcentajeInteraccion(mejor.getIdentificador(), 95.0);
	                repo.incrementaNumeroValoraciones(mejor.getIdentificador());
	                System.out.println("\nInteracción actualizada:");
	                System.out.println(mejor);
	            }

	            System.out.println("\nInteracciones con acierto > 70%:");
	            ArrayList<InteraccionAgente> filtradas = servicio.obtenerInteraccionesAciertoMayorQueOrdenadas(interacciones, 70.0);
	            for (InteraccionAgente i : filtradas) {
	                System.out.println(i);
	            }

	            servicio.grabarResumenEstadistica("resumenEstadistica.txt", interacciones);
	            System.out.println("\nResumen estadístico generado en resumenEstadistica.txt");

	            servicio.grabarFicheroCSV("salidaOrdenada.csv", interacciones);
	            System.out.println("CSV generado en salidaOrdenada.csv");

	        } catch (IOException e) {
	            System.out.println("Error al leer o escribir archivos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}
