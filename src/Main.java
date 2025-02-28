
public class Main {
	public static void main(String[] args) {
		Customer c1 = new Customer("123 Main St.", "Hayward", "CA", "93128", new Phone("91231"),  "c1@gmail.com");		
		c1.createAccount(); //Overloaded - when no address given it will use customer address for account address
		Account c1Account = c1.getAccount();
		
		Product GPU = new Product("6800 GT", new Supplier("EVGA"));
		LineItem GPUItem = new LineItem(4, new Price(400.0));
		GPUItem.setProduct(GPU);
		GPU.addLineItem(GPUItem);
		
		
		Product toothBrush = new Product("Brusher9000", new Supplier("Colgate"));
		LineItem toothBrushItem = new LineItem(2, new Price(10.0));
		toothBrushItem.setProduct(toothBrush);
		toothBrush.addLineItem(toothBrushItem);

// not using WebUser currently here. 		
		
// have c1Account.___() methods to abstract this.
// Might even be better to use c1.___()
		//ex: we need customer address to place order
		
		ShoppingCart s1 = new ShoppingCart();
		s1.addLineItem(GPUItem);
		s1.addLineItem(toothBrushItem);
		System.out.println("quantity decrement check: " + GPUItem.getQuantity());
		
		Order o1 = new Order(c1.getAddress(), s1.getLineItems());
		c1Account.addOrder(o1);
		// reset the shopping cart from here?
		System.out.println("Order total check: " + o1.getTotal());
		
		Payment p1 = new Payment(5.0, "giftcard", o1); // have constructor do "o1.AddPayment() for association" ???
		Payment p2 = new Payment(405.0, "credit card", o1);
		o1.addPayment(p1);
		o1.addPayment(p2);
		c1Account.addPayment(p1);
		c1Account.addPayment(p2);
		
		if (o1.getStatus() != OrderStatus.PAID) return;
		
		
		// Now you can place a new order?
		
	    	
//having Account do Payment would be nice for associations		
		
		
		
	}
}
