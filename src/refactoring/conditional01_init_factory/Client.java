package refactoring.conditional01_init_factory;


public class Client {
	public static void main(String[] args) {
		CustomerFactory factory = new CustomerFactory();
		Customer customer = factory.getCustomer(Customer.PREMIER);
		
		System.out.println(customer.getCustRating());
	}
}


 abstract class Customer {
	
	private String custRating;
	static final int PREMIER = 2;
	static final int VALUED = 1;
	static final int DEADBEAT = 0;
	
	public String getCustRating() {
		return custRating;
	}
	public void setCustRating(String custRating) {
		this.custRating = custRating;
	}

}

class DeadBeat extends Customer {

	public DeadBeat() {
		setCustRating("DeadBeat Customer");
	}
	
}

class Premier extends Customer {

	public Premier() {
		setCustRating("Premier Customer");
	}
	
}

class Valued extends Customer {

	public Valued() {
		setCustRating("Valued Customer");
	}
	
}

class CustomerFactory {
	public Customer getCustomer(int custType) {
		if (custType == Customer.DEADBEAT) {
			return new DeadBeat();
		} else if (custType == Customer.VALUED) {
			return new Valued();
		} else if (custType == Customer.PREMIER) {
			return new Premier();
		} else {
			throw new IllegalAccessError("cust type is not correct");
		}
	}
}