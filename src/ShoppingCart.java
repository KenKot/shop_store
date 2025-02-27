import java.time.LocalDateTime;

public class ShoppingCart {
	private LocalDateTime createdAt;
	
	private WebUser webuser;
//	private Account account;
	
//	public ShoppingCart(WebUser webuser, Account account) {
	public ShoppingCart(WebUser webuser) {
		this.createdAt = LocalDateTime.now();
		this.webuser = webuser;
//		this.account = account;
	}
	
	// GETTERS
	
	// SETTERS
	
	// ASSOCIATIONS
	public WebUser getWebUser() {
		return this.webuser;
	}
	public void setWebUser(WebUser webuser) {
		this.webuser = webuser;
	}
	
//	public Account getAccount() {
//		return this.account;
//	}

}
