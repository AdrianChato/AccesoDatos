package Simulacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarNSSFichero {
	private static final String ruta = "src/main/resources/";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("COUNT:0");
            return;
        }

        
        File entrada = new File(args[0]);
        File salida = new File(ruta + "NSSs.txt");

        int contador = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(entrada));
            FileWriter fw = new FileWriter(salida);
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("AN")) { // Identificamos los NSS
                    fw.write(linea + "\n");
                    contador++;
                }
            }
            fw.close();
            br.close();
            System.out.println("COUNT:" + contador);
        } catch (IOException e) {
            System.out.println("COUNT:0");
        }
    }
}
