package tema0;

import java.util.List;

public class Padre {

	
	
	public int metodo1 (int [] tabla) {
		int suma = 0;
		for (int i : tabla) {
			suma = suma+i;
		}
		
		return suma;
	}
	
	public int metodo1 (List <Integer> tabla) {
		int suma = 0;
		for (int i : tabla) {
			suma = suma+i;
		}
		
		return suma;
	}
}
