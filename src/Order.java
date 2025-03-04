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
	
	private HashSet<Payment> payments;
	private HashSet<LineItem> lineitems;
	
	
	// Programmer's Choice
	private double balanceLeft;
	
	
	public Order(Address shipTo, HashSet<LineItem> lineitems) {
		this.number = String.valueOf(++count);
		
		this.ordered = LocalDateTime.now();
		this.shipTo = shipTo;
		
		this.lineitems = lineitems;
		this.total = setTotal();
		
		
		this.balanceLeft = 0.0;
		for (LineItem li : lineitems) {
			this.balanceLeft += li.getPrice().getUSD();
		}
		
		
		this.payments = new HashSet<Payment>();
		
//		this.shipped = shipped; // to be updated later
		this.status = OrderStatus.NEW; // to be updated later
	}
	
	// GETTERS
		//programmers choice
	public boolean isPaid() {
		return this.balanceLeft <= 0;
	}
	public double getBalanceLeft() {
		return this.balanceLeft;
	}
	

	public String getNumber() {
		return this.number;
	}
	public LocalDateTime getOrdered() {
		return this.ordered;
	}
	public LocalDateTime getShipped() {
		return this.shipped;
	}
	public Address getShipTo() {
		return this.shipTo;
	}
	public OrderStatus getStatus() {
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
		//prevent additional payments
		if (this.isPaid()) return; 
		
		this.payments.add(payment);
		this.balanceLeft -= payment.getTotal();

		// no more payments needed
		if (this.isPaid()) {
			this.status = OrderStatus.PAID;
		}
	}
	
	public HashSet<Payment> getPayments(){
		return this.payments;
	}
	
	
	public void addLineItem(LineItem lineitem) {
		this.lineitems.add(lineitem);
	}
	public HashSet<LineItem> getLineItems() {
		return this.lineitems;
	}
	
}
