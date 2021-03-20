import java.util.ArrayList;

public class Store {
	private String storeName;
	private ArrayList<Product> itemsInStock;
	private ArrayList<Customer> customerList;
	
	public Store(String storeName, ArrayList<Product> itemsInStock, ArrayList<Customer> customerList) {
		this.storeName = storeName;
		this.itemsInStock = itemsInStock;
		this.customerList = customerList;
	}
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public ArrayList<Product> getItemsInStock() {
		return itemsInStock;
	}

	public void setItemsInStock(ArrayList<Product> itemsInStock) {
		this.itemsInStock = itemsInStock;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public String toString() {
		return storeName + " [itemsInStock= \n" + itemsInStock + "]\n\n [customerList= \n" + customerList + "]";
	}
	
	
	
}
