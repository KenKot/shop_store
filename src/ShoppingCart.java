import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCart {
	private LocalDateTime createdAt;
	
	private WebUser webuser;
	private LineItemList lineitems;
	
	public ShoppingCart() {
		this.createdAt = LocalDateTime.now();
		this.lineitems = new LineItemList();
	}
	
	// GETTERS
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	
	// SETTERS
	
	// ASSOCIATIONS
	public WebUser getWebUser() {
		return this.webuser;
	}
	public void setWebUser(WebUser webuser) {
		this.webuser = webuser;
	}
	
	public void addLineItem(LineItem lineitem) {
		lineitem.decrementQuantity();
		lineitems.add(lineitem);
	}
	public LineItemList getLineItems() {
		return lineitems;
	}
}
