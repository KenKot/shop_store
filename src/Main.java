
public class Main {
	private static int testCount = 0;
	

    public static void tester(String testname, boolean evaluation) {
    	String state;
    	if (evaluation) {
    		state = "passed";
    	} else {
    		state = "failed!\n^\n|\n";
    	}
        System.out.println("Running test " + (++testCount) + ": " + testname + " -- test " + state);

    }	

	public static void runBlackBoxTests() {
		System.out.println("Running black box tests...\n");
		
		//TEST 1 - Customers have Unique Id's
//		tester("Customers have Unique Id's", )
		
	}
	
	public static void main(String[] args) {
		Customer c1 = new Customer("123 Main St.", "Hayward", "CA", "93128", new Phone("91231"),  "c1@gmail.com");		
		Customer c2 = new Customer("123 Fake St.", "Seatle", "WA", "1318", new Phone("31231"),  "c2@gmail.com");		
		c1.createAccount(); //Overloaded - when no address given it will use customer address for account address
		Account c1Account = c1.getAccount();
		
		
		tester("Customers have Unique Id's", c1.getId() != c2.getId());
		tester("Customer has 1 account", c1.getAccount() instanceof Account);
		
		WebUser w1 = new WebUser("john", "pass123", c1);
		
		tester("Customer can register as webuser", w1.getCustomer().getEmail() == "c1@gmail.com");
		tester("Web user has login name", w1.getLoginId() == "john");
		tester("Customer may have no orders", c1.getOrders().size() == 0);
		
		
		w1.setUserState(UserState.ACTIVE);
		tester("Web user can be in several states", w1.getUserState() == UserState.ACTIVE);
		tester("Web user linked to a shopping cart", w1.getShoppingCart() instanceof ShoppingCart);
		
		
		Product GPU = new Product("6800 GT", new Supplier("EVGA"));
		LineItem GPUItem = new LineItem(4, new Price(400.0));
		GPUItem.setProduct(GPU);
		GPU.addLineItem(GPUItem);
		

		Product toothBrush = new Product("Brusher9000", new Supplier("Colgate"));
		LineItem toothBrushItem = new LineItem(2, new Price(10.0));
		toothBrushItem.setProduct(toothBrush);
		toothBrush.addLineItem(toothBrushItem);

		ShoppingCart s1 = c1.getAccount().getShoppingCart();
		s1.addLineItem(GPUItem);
		s1.addLineItem(toothBrushItem);
		
		Order o1 = new Order(c1.getAddress(), s1.getLineItems());
		c1Account.addOrder(o1);
		
		Payment p1 = new Payment(5.0, "giftcard", o1); // have constructor do "o1.AddPayment() for association" ???
		Payment p2 = new Payment(405.0, "credit card", o1);
		o1.addPayment(p1);
		o1.addPayment(p2);
		c1Account.addPayment(p1);
		c1Account.addPayment(p2);
		
		tester("Each order could refer to several payments, possibly none", o1.getPayments().size() > 1 );
		tester("Every payment has unique id",p1.getId() != p2.getId());  
		tester("Every payment has one account", p1.getAccount() instanceof Account);
		tester("Every order has current order status", o1.getStatus() == OrderStatus.PAID);
		tester("Each line item is related to 1 product", GPUItem.getProduct() instanceof Product && toothBrushItem.getProduct() instanceof Product);
		tester("Each line item is related to 1 product", GPUItem.getProduct() instanceof Product && toothBrushItem.getProduct() instanceof Product);
		
		
		
//		ShoppingCart s2 = new ShoppingCart();
		LineItem GPUItem2 = new LineItem(11, new Price(400.0));
		GPUItem2.setProduct(GPU);
		s1.addLineItem(GPUItem2);
		tester("Product could be associated w/ many line items, or none at all", GPU.getLineItems().size() > 1);
		
		
		
		tester("Account owns shopping cart", c1.getAccount().getShoppingCart() instanceof ShoppingCart);
		tester("Account owns orders", c1.getAccount().getOrders().contains(o1));
		tester("Shopping cart belongs to account", c1.getAccount().getShoppingCart() instanceof ShoppingCart);

		
		
		KenList<Customer> kl = new KenList<Customer>();
		kl.addItem(c1);
		
		
//		to do: tester("Both order and shopping cart have line items linked to a specific product", o1.)
		
//		to do: Customer orders are sorted and unique
	}
}
