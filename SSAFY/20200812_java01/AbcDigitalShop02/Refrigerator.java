package AbcDigitalShop02;

public class Refrigerator extends Product {
	int litter;
	public Refrigerator() {
		super();
	}
	
	public Refrigerator(int pid, String name,int price, int amount, int litter) {
		super(pid, name, price, amount);
		this.litter = litter;
	}
	

	public int getLitter() {
		return litter;
	}

	public void setLitter(int litter) {
		this.litter = litter;
	}

	@Override
	public String toString() {
		return "냉장고\t[" + super.toString() + ", 용량: " + this.litter + "L]";
	}
}
