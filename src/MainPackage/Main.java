package MainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader  =  new Scanner(System.in);
		System.out.println("Cant carros:");
		int cant =  reader.nextInt();
		
		long startTime = System.currentTimeMillis();
		System.out.println("---------PRUEBA ADD");
		
		HashTable ejemplo = new HashTable(5,2);
		for(int i =0;i<cant;i++) {
			Car nuevo = new Car(i);
			ejemplo.add(nuevo);
		}
		System.out.println("Yo ya me voy");
		ejemplo.print();
		System.out.println((System.currentTimeMillis()-startTime)+" ms");
	}

}
