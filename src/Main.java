
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

	
	public static void main(String[] args) {
		System.out.println("------------------------------------------------------------");
		System.out.println("RUNNING BLACK BOX TESTS:");
		System.out.println("------------------------------------------------------------");
		Customer c1 = new Customer("123 Main St.", "Hayward", "CA", "93128", new Phone("91231"),  "c1@gmail.com");		
		Customer c2 = new Customer("123 Fake St.", "Seatle", "WA", "1318", new Phone("31231"),  "c2@gmail.com");		
		c1.createAccount(); //Overloaded - when no address given it will use customer address for account address
		c2.createAccount(); //Overloaded - when no address given it will use customer address for account address
		Account c1Account = c1.getAccount();
		Account c2Account = c2.getAccount();
		
		
		tester("Customers have Unique Id's", c1.getId() != c2.getId());
		tester("Customer has 1 account", c1.getAccount() instanceof Account);
		tester("Customer can exist without WebUser", c2.getWebuser() == null);
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
		
		tester("Order could refer to no payments", o1.getPayments().size() == 0 );

		Payment p1 = new Payment(5.0, "giftcard", o1); // have constructor do "o1.AddPayment() for association" ???
		Payment p2 = new Payment(405.0, "credit card", o1);
		o1.addPayment(p1);
		o1.addPayment(p2);
		c1Account.addPayment(p1);
		c1Account.addPayment(p2);
		
		tester("Each order could refer to several payments", o1.getPayments().size() > 1 );
		tester("Every payment has unique id",p1.getId() != p2.getId());  
		tester("Every payment has one account", p1.getAccount() instanceof Account);
		tester("Every order has current order status", o1.getStatus() == OrderStatus.PAID);
		tester("Each line item is related to 1 product", GPUItem.getProduct() instanceof Product && toothBrushItem.getProduct() instanceof Product);
		
		
		
//		ShoppingCart s2 = new ShoppingCart();
		LineItem GPUItem2 = new LineItem(11, new Price(400.0));
		GPUItem2.setProduct(GPU);
		s1.addLineItem(GPUItem2);
		tester("Product could be associated w/ many line items, or none at all", GPU.getLineItems().size() > 1);
		
		
		
		tester("Account owns shopping cart", c1.getAccount().getShoppingCart() instanceof ShoppingCart);
		tester("Account owns orders", c1.getAccount().getOrders().contains(o1));
		tester("Shopping cart belongs to account", c1.getAccount().getShoppingCart() instanceof ShoppingCart);
		
		ShoppingCart s2 = c2.getAccount().getShoppingCart();
		LineItem GPUItem3 = new LineItem(44, new Price(400.0));
		s2.addLineItem(GPUItem3);
		Order o2 = new Order(c2.getAddress(), s2.getLineItems());
		c2Account.addOrder(o2);
		tester("Both order & shopping cart have line items linked to a specific product", o2.getLineItems().size() == s2.getLineItems().size());
		
		
		
		// Try and add the same order twice - it won't add as proven by same length
		int c1OrderCount = c1.getAccount().getOrders().size();
		c1Account.addOrder(o1);
		tester("Customer Orders are unique", c1.getOrders().size() == c1OrderCount);

		
		OrderList ol = new OrderList();
		ol.add(o2);
		ol.add(o1);
		
		Order[] orders= ol.getOrders();
		tester("Customer Orders are sorted", orders[0].getId().equals("1") && orders[1].getId().equals("2"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n\n------------------------------------------------------------");
		System.out.println("RUNNING WHITE BOX TESTING ON THE CLASS LineItem");
		System.out.println("------------------------------------------------------------");
		LineItem li1 = new LineItem(3, new Price(400));
		LineItem li2 = new LineItem(4, new Price(800));
		LineItem li3 = new LineItem(2, new Price(1400));
		Product Soda = new Product("Dr. Pepper", new Supplier("Pepsico"));
		li1.setProduct(Soda);
		Product Cheese = new Product("Cheddar", new Supplier("Kraft"));
		li1.setProduct(Cheese);
		
		li1.setShoppingCart(s2);
		li1.setOrder(o2);
		
//		LineItemList lil = new LineItemList();
//		lil.add(Soda);
//		lil.add(Cheese)
//		
//		s1.addLineItem(Soda);
//		s1.addLineItem(Cheese);
		
		
		
		tester("ID's are unique & set in constructor", li1.getId().equals("5") && li2.getId().equals("6") && li3.getId().equals("7"));

		tester("Line Item has a number quantity", li1.getQuantity() >= 0);

		tester("Line Item has a price (which also has a usd value)", li1.getPrice() instanceof Price && li1.getPrice().getUSD() >= 0);
		
		
		int initCount = li3.getQuantity();
		li3.decrementQuantity();
		tester("line item can decrement in quanitity", initCount - 1 ==  li3.getQuantity());
		
		
		li3.decrementQuantity();
		li3.decrementQuantity();
		li3.decrementQuantity();
		li3.decrementQuantity();
		li3.decrementQuantity();
		tester("line item can't decrement past 0", li3.getQuantity() >= 0);

		li3.setQuantity(111);
		tester("Can set quantity", li3.getQuantity() == 111);
		
		li3.setPrice(new Price(999));
		tester("can set price", li3.getPrice().getUSD() == 999);
		
		tester("Line item associated with a product", li1.getProduct() instanceof Product);
		tester("Line item associated with a shopping cart", li1.getShoppingCart() instanceof ShoppingCart);
		tester("Line item associated with a order", li1.getOrder() instanceof Order);
//		tester("", );
	}
}
