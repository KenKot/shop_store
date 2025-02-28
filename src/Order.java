import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Order {
	private static int count = 0;
	
	private String number;
	private LocalDateTime ordered;
	private LocalDateTime shipped;
	private Address shipTo;
	private OrderStatus status;
	private double total;
	
	private Set<Payment> payments;
	private Set<LineItem> lineitems;
	
	
	public Order(Address shipTo, Set<LineItem> lineitems) {
		this.number = String.valueOf(++count);
		
		this.ordered = LocalDateTime.now();
		this.shipTo = shipTo;
		
		this.lineitems = lineitems;
		this.total = setTotal();
		
		this.payments = new HashSet<Payment>();
		
//		this.shipped = shipped; // to be updated later
		this.status = OrderStatus.NEW; // to be updated later
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
	public double getTotal() {
		return this.total;
	}

	// SETTERS
	private double setTotal() {
		double total = 0.0;
		for (LineItem item : this.lineitems) {
			total +=  item.getPrice().getUSD();
		}
		return total;
	}

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
//	public void setAccount(Account account) {
//		this.account = account;
//	}
	
	public void addPayment(Payment payment) {
		this.payments.add(payment);
	}
	
	
	public void addLineItem(LineItem lineitem) {
		this.lineitems.add(lineitem);
	}
	
	
}
