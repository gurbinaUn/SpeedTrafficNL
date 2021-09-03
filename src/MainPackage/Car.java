package MainPackage;

public class Car {

	private long tiempoIn;
	private long tiempoOut;
	private int id;
	
	public Car(int id) {
		super();
		this.id = id;
	}
	public long getTiempoIn() {
		return tiempoIn;
	}
	public void setTiempoIn(int tiempoIn) {
		this.tiempoIn = tiempoIn;
	}
	public long getTiempoOut() {
		return tiempoOut;
	}
	public void setTiempoOut(int tiempoOut) {
		this.tiempoOut = tiempoOut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long tiempoEnSimulaccion() {
		return this.tiempoOut - this.tiempoIn;
	}
	
}
