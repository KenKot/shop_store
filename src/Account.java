import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Account {
	private static int count = 0;
	
	private String id;
	private Address billing_address; 
	private boolean is_closed;
	private LocalDateTime open;
	private LocalDateTime closed;
	
	private ShoppingCart shoppingcart;
	
	private PaymentList payments;
	private OrderList orders;
	
	
	public Account(Address address) {
		this.id = String.valueOf(++count);
		this.billing_address = address;
		this.is_closed = false;
		this.open = LocalDateTime.now();
		
		
		this.shoppingcart = new ShoppingCart();
		
		this.payments = new PaymentList();
		this.orders = new OrderList();
		
	}
	
	// GETTERS
	
	public String getId() {
		return this.id;
	}
	
	public OrderList getOrders(){ 
		return this.orders;
	}
	// SETTERS
	
	// ASSOCIATIONS

	public ShoppingCart getShoppingCart() {
		return this.shoppingcart;
	}
	
	public void addPayment(Payment payment) {
		payments.add(payment);
		payment.setAccount(this);
	}

	public void addOrder(Order order) {
		orders.add(order);
	}
}
