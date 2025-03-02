public class LineItem {
	private int quantity;
	private Price price;
	
	private Product product;
	private ShoppingCart shoppingcart;
	private Order order;
	
	public LineItem(int quantity, Price price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	
	// GETTERS
	public int getQuantity() {
		return this.quantity;
	}
	
	public Price getPrice() {
		return this.price;
	}
	
	// SETTERS
	public void decrementQuantity() {
		if (this.quantity > 0) {
			this.quantity--;
		}
	}
	
	public void setQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}
	
	public void setPrice(Price newPrice) {
		this.price = newPrice;
	}
	
	
	// ASSOCIATIONS
	public Product getProduct() {
		return this.product;
	}
	public void setProduct(Product product) {
		this.product = product;
		product.addLineItem(this);
	}
	
	public void setShoppingCart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
}
