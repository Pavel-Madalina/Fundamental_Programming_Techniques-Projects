package ro.tuc.pt.assig_2;

public class Client {
	private int id;
	private int arrivalTime;
	private int serviceTime;
	private int exitTime;

	public Client(int id, int arrivalTime, int serviceTime) {
		super();
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.exitTime = this.arrivalTime + this.serviceTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getExitTime() {
		return exitTime;
	}

	public void setExitTime(int exitTime) {
		this.exitTime = exitTime;
	}

	@Override
	public String toString() {
		return "id:" + id;
	}

}
