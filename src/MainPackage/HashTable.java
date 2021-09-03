package MainPackage;

import java.util.LinkedList;
import org.apache.commons.math3.primes.Primes;


public class HashTable {

	private int nodos=0;
	private int m = 0;
	private LinkedList<Car>[] array;
	private HashFunction hashF;

	public HashTable(int mSize) {
		this.m=mSize;
		this.hashF = new HashFunction(mSize);
		this.array = new LinkedList[mSize];
	}
	
	public LinkedList[] getArray() {
		return array;
	}

	public void setArray(LinkedList[] array) {
		this.array = array;
	}

	public boolean find(Car car) {
		LinkedList<Car> chain = array[this.hashF.hash(car.getId())];
		for (Car carEval : chain) {
			if (car.equals(carEval)) {
				return true;
			}
		}
		return false;
	}

	public void add(Car car) {
		LinkedList<Car> chain = array[this.hashF.hash(car.getId())];
		if (chain != null) {
			for (Car carEval : chain) {
				if (car.getId()==carEval.getId()) {
					return;
				}
			}
			chain.add(car);
			this.nodos++;
		} else {
			LinkedList chainNew = new LinkedList();
			chainNew.add(car);
			this.nodos++;
			array[this.hashF.hash(car.getId())]=chainNew;
		}
		this.reHash();
	}

	public void remove(Car car) {
		if (!find(car)) {
			return;
		}
		LinkedList<Car> chain = array[this.hashF.hash(car.getId())];
		chain.remove();
		this.nodos--;
	}

	public void reHash() {
		double alpha = nodos / m;
		if (alpha > 0.9) {
			HashTable Tnew = new HashTable(2 * this.m);
			HashFunction Fnew = new HashFunction(2*this.m);
			
			for (LinkedList<Car> chainEval : this.array) {
				if (chainEval!=null && !chainEval.isEmpty()) {
					for (Car carEval : chainEval) {
						Tnew.add(carEval);
					}
				}
			}
			this.array = Tnew.getArray();
			this.hashF = Fnew;
			System.out.println("ReHash efectivo, nuevo tamaño:" + this.array.length);
		}
	}


	public void print() {
		for(int i =0; i<array.length;i++) {
			LinkedList list = array[i];
			System.out.print(i+" ");
			if(list==null) {
				System.out.println("null");
			} else {
				for(Object car: list) {
					Car carEval = (Car)car;
					System.out.print(carEval.getId()+" ");
				}
				System.out.println();
			}
		}
	}

}
