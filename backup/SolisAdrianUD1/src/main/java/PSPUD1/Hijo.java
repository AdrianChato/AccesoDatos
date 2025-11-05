package PSPUD1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Hijo {
	private static final String RUTA_BASE = "src/main/resources/";

	public static void main(String[] args) throws IOException {
	    if (args.length < 1) {
	        System.err.println("Uso: java SeparardorPorSensores");
	        System.exit(1);
	    }

	    String ficheroEntrada = RUTA_BASE + args[0];
	    String separador = args[1];
	    String ficheroSalida = RUTA_BASE + separador + ".txt";

	    List<String> lineasSeparadores = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
	        String linea = br.readLine(); 
	        while ((linea = br.readLine()) != null) {
	            String[] partes = linea.split(";");

	            if (partes.length >= 1) {
	                String provinciaLinea = partes[0].trim(); 
	                if (provinciaLinea.equalsIgnoreCase(separador)) {
	                	lineasSeparadores.add(linea);
	                }
	            }
	        }
	    }

	    try (PrintWriter pw = new PrintWriter(new FileWriter(ficheroSalida))) {
	        for (String l : lineasSeparadores) {
	            pw.println(l);
	        }
	    }

	    System.out.println(separador + " : " + lineasSeparadores.size());
	}
	}
