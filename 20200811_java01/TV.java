package AbcDigitalShop02;

public class TV extends Product {
	int inch;
	public TV() {
		super();
	}
	
	public TV(int pid, String name,int price, int amount, int inch) {
		super(pid, name, price, amount);
		this.inch = inch;
	}

	
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "TV [" + super.toString() + ",크기: " + this.inch + "인치]";
	}
	
}

