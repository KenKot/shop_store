import java.time.LocalDateTime;

public class Payment {
	private static int count = 0;
	
	private String id;
	private LocalDateTime paid;
	private double total;
	private String details;
	
	private Order order;
	private Account account;
	
//	public Payment(LocalDateTime ldt, double total, String details) {
	public Payment(double total, String details, Order order) {
		this.id = String.valueOf(++count);
		this.paid = LocalDateTime.now(); 
		this.total = total;
		this.details = details;
		
		this.order = order;

	}
	
	// GETTERS
	public String getId() {
		return this.id;
	}

	public LocalDateTime getPaid() {
		return this.paid;
	}

	public double getTotal() {
		return this.total;
	}

	public String getDetails() {
		return this.details;
	}
	// SETTERS
	
	// ASSOCIATIONS
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
}
