package tema0;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		int [] array = {1,2,3};
		List <Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		Padre p = new Padre();
		p.metodo1(array);
		System.out.println(p.metodo1(lista));
		System.out.println(p.metodo1(array));
	}

}
