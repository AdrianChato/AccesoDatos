package Unidad2.Boletin1;

public class Hijo2 extends Thread{

	private String nombreHilo;

	public Hijo2(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	@Override
	public void run() {
		boolean sigue = true;
		while (sigue) {
		System.out.println("Procesos");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		System.out.println("Hilo terminado");
	}
	
}
