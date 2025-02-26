import java.time.LocalDateTime;

public class Account {
	private static int count = 0;
	
	private String id;
//	private Address billing_address;
	private boolean is_closed;
	private LocalDateTime open;
	private LocalDateTime closed;
	
	
	public Account() {
		this.id = String.valueOf(++count);
		this.is_closed = false;
		
		
		this.open = LocalDateTime.now(); 
		System.out.println("ACCOUNT CONSTRUCTOR RAN");
	}
}
