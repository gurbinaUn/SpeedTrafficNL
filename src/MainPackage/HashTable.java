package MainPackage;

import java.util.LinkedList;

public class HashTable {

	private int nodos;
	private int m = 0;
	private LinkedList[] array;
	private int a;
	private int b;
	
	public HashTable(int m) {
		this.array = new LinkedList[m];
	}

	public LinkedList[] getArray() {
		return array;
	}

	public void setArray(LinkedList[] array) {
		this.array = array;
	}

	public boolean find(Car car) {
		LinkedList<Car> chain = array[hash(car)];
		for (Object carEval : chain) {
			if (car.equals(carEval)) {
				return true;
			}
		}
		return false;
	}

	public void add(Car car) {
		LinkedList<Car> chain = array[hash(car)];
		for (Object carEval : chain) {
			if (car.equals(carEval)) {
				return;
			}
		}
		chain.add(car);
		this.nodos++;
	}
	
	public void remove(Car car) {
		if(!find(car)) {
			return;
		}
		LinkedList<Car> chain = array[hash(car)];
		chain.remove();
		this.nodos--;
	}

	public void reHash() {
		double alpha = nodos/m;
		if (alpha>0.9) {
			HashTable nueva = new HashTable(2*this.m);
			this.choseNewH();
			for(LinkedList<Car> chainEval: this.array) {
				if(!chainEval.isEmpty()) {
					for(Car carEval: chainEval) {
						nueva.add(carEval);
					}
				}
			}
			this.array = nueva.getArray();
		}
	}
	
	public int hash(Car car) {
		return 1;
	}
	
	public int[] choseNewH() {
		this.a=1;
		this.b=2;
		int result[] = {a,b};
		return result;
	}

}
