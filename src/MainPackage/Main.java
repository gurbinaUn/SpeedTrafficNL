package MainPackage;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("---------PRUEBA ADD");
		
		HashTable ejemplo = new HashTable(5,2);
		for(int i =0;i<25;i++) {
			Car nuevo = new Car(i);
			ejemplo.add(nuevo);
			System.out.println("Carro n�mero " + nuevo.getId()+ " agregado");
		}
		System.out.println("Yo ya me voy");
	}

}