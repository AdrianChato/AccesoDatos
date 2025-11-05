package PSPUD1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Padre {
	 private static final String CLASSES_DIR = "target/classes";
	    private static final String JAVA_SRC = "src/main/java/";

	    public void compila() {
	        String[] comando = { "javac", "-d", CLASSES_DIR,
	                JAVA_SRC + "PSPUD1/Hijo.java" };

	        try {
	            ProcessBuilder pb = new ProcessBuilder(comando);
	            pb.inheritIO();
	            Process p = pb.start();
	            p.waitFor();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public String ejecuta(String fichero, String sensor) {
	        String[] comando = { "java", "-cp", CLASSES_DIR, JAVA_SRC +
	        		"PSPUD1/Hijo.java", fichero, sensor };

	        StringBuilder salida = new StringBuilder();

	        try {
	            ProcessBuilder pb = new ProcessBuilder(comando);
	            pb.redirectErrorStream(true);
	            Process p = pb.start();
	            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                salida.append(linea).append("\n");
	            }
	            p.waitFor();
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }

	        return salida.toString().trim();
	    }

	    public static void main(String[] args) {
	    	Padre lanzador = new Padre();
	        lanzador.compila();

	        String fichero = "lecturas.txt";
	        String[] provincias = { "TEMPERATURA", "HUMEDAD", "PRESION"};

	        int total = 0;

	        for (String provincia : provincias) {
	            String salida = lanzador.ejecuta(fichero, provincia);
	            System.out.println(salida);

	            // Extraer número de pedidos
	            if (salida.contains(":")) {
	                try {
	                    int num = Integer.parseInt(salida.split(":")[1].trim());
	                    total += num;
	                } catch (NumberFormatException ignored) {}
	            }
	        }

	        System.out.println("Nº total de Sensores : " + total);
	    }
	}