import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCart {
	private LocalDateTime createdAt;
	
	private WebUser webuser;
	private Set<LineItem> lineitems;
	
	public ShoppingCart() {
		this.createdAt = LocalDateTime.now();
		this.lineitems = new HashSet<LineItem>();
	}
	
	// GETTERS
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	//moved to Order
//	public double getTotal() {
//		double total = 0.0;
//		for (LineItem item : lineitems) {
//			total += item.getQuantity() * item.getPrice().getUSD();
//		}
//		return total;
//	}
	
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
	public Set<LineItem> getLineItems() {
		return lineitems;
	}
}
