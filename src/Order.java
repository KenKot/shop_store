import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Order {
	private String number;
	private LocalDateTime ordered;
	private LocalDateTime shipped;
	private Address shipTo;
	private OrderStatus status;
	private float total;
	
	private Account account;
	private Set<Payment> payments;
	private Set<LineItem> lineitems;
	
	
	public Order(String number, LocalDateTime ordered, LocalDateTime shipped, Address shipTo, float total ) {
		this.number = number;
		this.ordered = ordered;
		this.shipped = shipped;
		this.shipTo = shipTo;
		this.status = OrderStatus.PENDING;
		this.total = total;
		
		this.payments = new HashSet<Payment>;
		this.lineItems = new HashSet<LineItem>;
	}
	
	// GETTERS
	public String getNumber() {
		return this.number;
	}
	public LocalDateTime getOrdered() {
		return this.ordered;
	}
	public LocalDateTime getshipped() {
		return this.shipped;
	}
	public Address getshipTo() {
		return this.shipTo;
	}
	public OrderStatus getstatus() {
		return this.status;
	}
	public Address getTotal() {
		return this.total;
	}

	// SETTERS
	public void setNumber(String number) {
		this.number = number;
	}
	public void setOrdered(LocalDateTime newDate) {
		this.ordered = newDate;
	}
	public void setshipped(LocalDateTime newDate) {
		this.shipped = newDate;
	}
	public void setshipTo(Address newAddress) {
		this.shipTo = newAddress;
	}
	public void setStatus(OrderStatus newStatus) {
		this.status = newStatus;
	}
	public void setTotal(float newTotal) {
		this.total = newTotal;
	}
	// ASSOCIATIONS
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void addPayment(Payment payment) {
		this.payments.add(payment);
	}
	
	
	public void addLineItem(LineItem lineitem) {
		this.lineitems.add(lineitem);
	}
	
	
}
