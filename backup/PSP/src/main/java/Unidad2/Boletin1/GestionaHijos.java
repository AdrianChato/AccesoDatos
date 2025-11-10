package Unidad2.Boletin1;

public class GestionaHijos {
	
	public static void main(String[] args) {
		Hijo1 runnable1 = new Hijo1("hilo1");
		Hijo2 hijo2 = new Hijo2("hilo2");
		Thread hilo1 = new Thread(runnable1);
		hilo1.start();
		hijo2.start();

		System.out.println("Termina el padre");
	}
	


}
