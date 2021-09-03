package MainPackage;

import java.util.LinkedList;

public class HashTable {

	private int nodos;
	private int m = 0;
	private LinkedList[] array;
	private int a;
	private int b;

	public HashTable(int size) {
		this.m=size;
		this.array = new LinkedList[size];
	}

	public LinkedList[] getArray() {
		return array;
	}

	public void setArray(LinkedList[] array) {
		this.array = array;
	}

	public boolean find(Car car) {
		LinkedList<Car> chain = array[hash(car)];
		for (Car carEval : chain) {
			if (car.equals(carEval)) {
				return true;
			}
		}
		return false;
	}

	public void add(Car car) {
		LinkedList<Car> chain = array[hash(car)];
		if (chain != null) {
			for (Car carEval : chain) {
				if (car.equals(carEval)) {
					return;
				}
			}
		} else {
			chain = new LinkedList();
		}
		chain.add(car);
		this.nodos++;
	}

	public void remove(Car car) {
		if (!find(car)) {
			return;
		}
		LinkedList<Car> chain = array[hash(car)];
		chain.remove();
		this.nodos--;
	}

	public void reHash() {
		double alpha = nodos / m;
		if (alpha > 0.9) {
			HashTable nueva = new HashTable(2 * this.m);
			this.choseNewH();
			for (LinkedList<Car> chainEval : this.array) {
				if (!chainEval.isEmpty()) {
					for (Car carEval : chainEval) {
						nueva.add(carEval);
					}
				}
			}
			this.array = nueva.getArray();
			System.out.println("ReHash efectivo, nuevo tamaño:" + this.array.length);
		}
	}

	public int hash(Car car) {
		return 1;
	}

	public int[] choseNewH() {
		this.a = 1;
		this.b = 2;
		int result[] = { a, b };
		return result;
	}

}
