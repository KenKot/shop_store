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
	
	private PaymentList payments;
	private LineItemList lineitems;
	
	
	private double balanceLeft;
	
	
	public Order(Address shipTo,  LineItemList lineitems) {
		this.number = String.valueOf(++count);
		
		this.ordered = LocalDateTime.now();
		this.shipTo = shipTo;
		
		this.lineitems = lineitems;
		this.total = setTotal();
		
		
		this.balanceLeft = 0.0;
		
		
		
		for (int i = 0; i < lineitems.size(); i++) {
			this.balanceLeft += lineitems.get(i).getPrice().getUSD();
		}
		
		
		this.payments = new PaymentList();
		
		this.status = OrderStatus.NEW; // to be updated later
	}
	
	// GETTERS
	public boolean isPaid() {
		return this.balanceLeft <= 0;
	}
	public double getBalanceLeft() {
		return this.balanceLeft;
	}
	

	public String getId() {
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

		for (int i = 0; i < lineitems.size(); i++) {
			total += lineitems.get(i).getPrice().getUSD();
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
	
	public PaymentList getPayments(){
		return this.payments;
	}
	
	
	public void addLineItem(LineItem lineitem) {
		this.lineitems.add(lineitem);
	}
	public LineItemList getLineItems() {
		return this.lineitems;
	}
	
}
