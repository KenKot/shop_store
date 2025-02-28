import java.util.ArrayList;

public class Product {
	private static int count = 0;
	
	private String id;
	private String name;
	private Supplier supplier;
	
	private ArrayList<LineItem> lineitems;
	
	public Product(String name, Supplier supplier) {
		this.id = String.valueOf(++count);
		this.name = name;
		this.supplier = supplier;
		
		this.lineitems = new ArrayList<LineItem>();
	}
	
	// GETTERS
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Supplier getSupplier() {
		return this.supplier;
	}
	
	
			
	// SETTERS
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setSupplier(Supplier newSupplier) {
		this.supplier = newSupplier;
	}
	
	
	
	// ASSOCIATIONS
	public ArrayList<LineItem> getLineItems(){
		return this.lineitems;
	}
	public void addLineItem(LineItem lineitem) {
		this.lineitems.add(lineitem);
		
	}
	
}
