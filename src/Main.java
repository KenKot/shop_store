
public class Main {
	public static void main(String[] args) {
		Address add1 = new Address("123 main st.", "Hayward", "CA", "12322");
		Phone p1 = new Phone("123-123-1234");
			
		Customer c1 = new Customer(add1, p1, "c1@gmail.com");
		Customer c2 = new Customer(add1, p1, "c2@gmail.com");
		
		Account a1 = new Account(add1);
		Account a2 = new Account(add1);

// Each customer has unique id and is linked to exactly one account. 		
		System.out.println("Each customer has unique id and is linked to exactly one account.");
		System.out.println("c1 id is: " + c1.getId());
		System.out.println("c2 id is: " + c2.getId());
				
		c1.setAccount(a1);
		c1.setAccount(a2);
		System.out.println("c1 only having 1 account despite trying to add 2: " + c1.getAccount());
		
		
		System.out.println("Program ended");
	}
}
