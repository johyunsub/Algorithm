package AbcDigitalShop;

public class Product {
	private int pid;
	private String name;
	private int price;
	private int amount;
	
	public Product() {}
	
	public Product(int pid, String name, int price, int amount) {
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "상품번호: " + pid + ", 상품명: " + name + ", 가격: " + price + ", 수량: " + amount;
	}
	
	
}
