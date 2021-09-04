package MainPackage;

import java.util.LinkedList;
import org.apache.commons.math3.primes.Primes;


public class HashTable {

	private int nodos=0;
	private int m;
	private LinkedList<Car>[] array;
	private HashFunction hashF;
	private int L;

	public HashTable(int mSize, int lSize) {
		this.m=mSize;
		this.L =lSize;
		this.hashF = new HashFunction(mSize,lSize);
		this.array = new LinkedList[mSize];
	}

	
	public int getNodos() {
		return nodos;
	}


	public void setNodos(int nodos) {
		this.nodos = nodos;
	}


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public LinkedList<Car>[] getArray() {
		return array;
	}


	public void setArray(LinkedList<Car>[] array) {
		this.array = array;
	}


	public HashFunction getHashF() {
		return hashF;
	}


	public void setHashF(HashFunction hashF) {
		this.hashF = hashF;
	}


	public int getL() {
		return L;
	}


	public void setL(int l) {
		L = l;
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
		this.reHash(Integer.toString(car.getId()).length());
	}

	public void remove(Car car) {
		if (!find(car)) {
			return;
		}
		LinkedList<Car> chain = array[this.hashF.hash(car.getId())];
		chain.remove();
		this.nodos--;
	}

	public void reHash(int Lnew) {
		float alpha = (float)this.nodos / this.m;
		if (alpha > 0.9) {
			
			HashTable Tnew = new HashTable(2 * this.m,Lnew);
			
			for (LinkedList<Car> chainEval : this.array) {
				if (chainEval!=null && !chainEval.isEmpty()) {
					for (Car carEval : chainEval) {
						Tnew.add(carEval);
					}
				}
			}
			this.nodos = Tnew.getNodos();
			this.m = Tnew.getM();
			this.array = Tnew.getArray();
			this.hashF = Tnew.getHashF(); 
			this.L = Tnew.getL();
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
