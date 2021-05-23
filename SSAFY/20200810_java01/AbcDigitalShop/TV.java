package AbcDigitalShop;

public class TV extends Product {
	public TV() {
		super();
	}
	
	public TV(int pid, String name,int price, int amount) {
		super(pid, name, price, amount);
	}

	@Override
	public String toString() {
		return "TV [" + super.toString() + "]";
	}
	
	
}
