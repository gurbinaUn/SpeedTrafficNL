package MainPackage;

import java.util.LinkedList;

import org.apache.commons.math3.primes.Primes;

public class HashTable {

	private int nodos;
	private int m = 0;
	private LinkedList[] array;
	private int a;
	private int b;
	private int p;
	
	

	public HashTable(int mSize) {
		this.p= 1;
		this.m=mSize;
		this.array = new LinkedList[mSize];
	}
	
	public HashTable(int mSize, int LCar) {
		this.p= Primes.nextPrime(10^LCar);
		this.m=mSize;
		this.array = new LinkedList[mSize];
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
				if (car.getId()==carEval.getId()) {
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
		return ((a*car.getId()+b)%p)%m;
	}

	public int[] choseNewH() {
		
		this.a = (int)(Math.random()*(p-1)+1);
		this.b = (int)(Math.random()*p);
		int result[] = { a, b };
		return result;
	}

}
