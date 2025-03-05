public class LineItem {
	private static int count = 0;
	
	private String id;
	private int quantity;
	private Price price;
	
	private Product product;
	private ShoppingCart shoppingcart;
	private Order order;
	
	public LineItem(int quantity, Price price) {
		this.id = String.valueOf(++count);
		this.quantity = quantity;
		this.price = price;
	}
	
	
	// GETTERS
	public int getQuantity() {
		return this.quantity;
	}
	
	public String getId() {
		return this.id;
	}
	public Price getPrice() {
		return this.price;
	}
	
	// SETTERS
	public void decrementQuantity() {
		if (this.quantity > 0) {
			this.quantity--;
		} else {
			System.out.println("Quantity is 0, cannot decrement any more!");
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
	public ShoppingCart getShoppingCart() {
		return this.shoppingcart;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	public Order getOrder() {
		return this.order;
	}
}
