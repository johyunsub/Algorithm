package AbcDigitalShop;

public class Refrigerator extends Product {
	public Refrigerator() {
		super();
	}
	
	public Refrigerator(int pid, String name,int price, int amount) {
		super(pid, name, price, amount);
	}

	@Override
	public String toString() {
		return "Refrigerator [" + super.toString() + "]";
	}
}
