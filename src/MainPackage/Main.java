package MainPackage;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("---------PRUEBA ADD");
		
		HashTable ejemplo = new HashTable(5);
		for(int i =0;i<25;i++) {
			Car nuevo = new Car(i);
			ejemplo.add(nuevo);
		}
		System.out.println("Yo ya me voy");
		ejemplo.print();
	}

}
