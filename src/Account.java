import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Account {
	private static int count = 0;
	
	private String id;
	private Address billing_address; // perhaps make setter, not use constructor
	private boolean is_closed;
	private LocalDateTime open;
	private LocalDateTime closed;
	
//	private Customer customer;
	private ShoppingCart shoppingcart;
	private ArrayList<Payment> payments;
	private Set<Order> orders;
	
	
	public Account(Address address) {
		this.id = String.valueOf(++count);
		this.billing_address = address;
		this.is_closed = false;
		this.open = LocalDateTime.now();
		
		this.payments = new ArrayList<Payment>();
		this.orders = new HashSet<Order>();
		
	}
	
	// GETTERS
	
	public String getId() {
		return this.id;
	}
	
	// SETTERS
	
	// ASSOCIATIONS
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
//	public void setShoppingCart(ShoppingCart shoppingcart) {
//		this.shoppingcart = shoppingcart;
//	}
	
	public void addPayment(Payment payment) {
		payments.add(payment);
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	
//	public void createShoppingCart(WebUser webuser) {
//		this.shoppingcart = new ShoppingCart(webuser);
//	}
}
