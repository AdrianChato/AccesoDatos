package Unidad1.Boletin1;

import java.io.IOException;

public class Ejemplo {

	public static void main(String[] args) {
		Runtime kernel = Runtime.getRuntime();
		
		System.out.println(kernel.freeMemory());
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.totalMemory());
		String [] arg = {"C:\\Program Files\\MySQL\\MySQL Workbench 8.0\\MySQLWorkbench.exe"};
		try {
			kernel.exec(arg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
