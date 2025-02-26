
public class Payment {
	private static int count = 0;
	
	private String id;
	private LocalDateTime paid;
	private float total;
	String details String;
	
	private Order order;
	private Account account;
	
	public Payment(LocalDateTime ldt, float total, String details) {
		this.id = String.valueOf(++count);
		this.paid = ldt;
		this.total = total;
		this.details = details;		
	}
	
	// GETTERS
	
	// SETTERS
	
	// ASSOCIATIONS
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
