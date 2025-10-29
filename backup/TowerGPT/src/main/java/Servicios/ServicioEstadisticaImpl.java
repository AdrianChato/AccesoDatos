package Servicios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import Modelos.InteraccionAgente;
import Modelos.TipoAgente;

public class ServicioEstadisticaImpl {
	public InteraccionAgente obtenerInteraccionConMejorValoracion(ArrayList<InteraccionAgente> interacciones) {
        InteraccionAgente mejor = null;
        int max = -1;
        for (InteraccionAgente i : interacciones) {
            if (i.getNumValoracionesPositivas() > max) {
                mejor = i;
                max = i.getNumValoracionesPositivas();
            }
        }
        return mejor;
    }

    public double calcularTiempoMedioPorTipo(TipoAgente tipo, ArrayList<InteraccionAgente> interacciones) {
        double suma = 0;
        int contador = 0;
        for (InteraccionAgente i : interacciones) {
            if (i.getTipo() == tipo) {
                suma += i.getTiempoEjecucion();
                contador++;
            }
        }
        if (contador == 0) return 0;
        return suma / contador;
    }

    public double calcularPorcentajeAciertoMedioPorTipo(TipoAgente tipo, ArrayList<InteraccionAgente> interacciones) {
        double suma = 0;
        int contador = 0;
        for (InteraccionAgente i : interacciones) {
            if (i.getTipo() == tipo) {
                suma += i.getPorcentajeAcierto();
                contador++;
            }
        }
        if (contador == 0) return 0;
        return suma / contador;
    }

    public ArrayList<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas(ArrayList<InteraccionAgente> interacciones, double porcentaje) {
        ArrayList<InteraccionAgente> lista = new ArrayList<>();
        for (InteraccionAgente i : interacciones) {
            if (i.getPorcentajeAcierto() > porcentaje) {
                lista.add(i);
            }
        }

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getPorcentajeAcierto() > lista.get(j).getPorcentajeAcierto()) {
                    InteraccionAgente temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        return lista;
    }

    public HashMap<TipoAgente, ArrayList<InteraccionAgente>> agruparInteraccionesPorTipo(ArrayList<InteraccionAgente> interacciones) {
        HashMap<TipoAgente, ArrayList<InteraccionAgente>> mapa = new HashMap<>();
        for (InteraccionAgente i : interacciones) {
            TipoAgente tipo = i.getTipo();
            if (!mapa.containsKey(tipo)) {
                mapa.put(tipo, new ArrayList<InteraccionAgente>());
            }
            mapa.get(tipo).add(i);
        }
        return mapa;
    }

    public ArrayList<InteraccionAgente> cargarRegistrosDesdeJSON(String ruta) throws IOException {
        Gson gson = new Gson();
        FileReader fr = new FileReader(ruta);
        InteraccionAgente[] array = gson.fromJson(fr, InteraccionAgente[].class);
        fr.close();

        ArrayList<InteraccionAgente> lista = new ArrayList<>();
        for (InteraccionAgente i : array) {
            lista.add(i);
        }
        return lista;
    }

    public void grabarFicheroCSV(String ruta, ArrayList<InteraccionAgente> interacciones) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(ruta));
        pw.println("id,tipo,peticion,respuesta,tiempo,valoraciones,acierto");
        for (InteraccionAgente i : interacciones) {
            pw.println(i.getIdentificador() + "," + i.getTipo() + "," + i.getPeticion() + "," +
                       i.getRespuesta() + "," + i.getTiempoEjecucion() + "," +
                       i.getNumValoracionesPositivas() + "," + i.getPorcentajeAcierto());
        }
        pw.close();
    }

    public void grabarResumenEstadistica(String ruta, ArrayList<InteraccionAgente> interacciones) {
    }
}
