import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingRunner {
	
	//method to find the least expensive item in the store
	public static Product findLeastExpensiveItem(Store store) {
		
		//placing all products in array and removing the first line which is the header info
		ArrayList<Product> items = new ArrayList<Product>();
		items = store.getItemsInStock();
		items.remove(0);
		
		//creating array to take all the prices
		ArrayList<Double> prices = new ArrayList<Double>();
		
		//inputting all the prices into the prices Array
		for(Product prod: items) {
			String sPrice = prod.getProductPrice();
			//prices is defined as a String in the Product class, so it has to be changed to a Double here
			double num = Double.parseDouble(sPrice);
			prices.add(num);
		}
		
		//for loop to order all the numbers in the prices array from least to greatest
		for(int i = 0; i < prices.size()-1; i++){
			double x, y;
			x = prices.get(i);
			y = prices.get(i+1);
									
			if(x > y) {
				prices.set(i, y);
				prices.set(i+1, x);
				int z = i;
				while(z > 0) {
					double a = prices.get(z);
					double b = prices.get(z-1);
					if(a < b) {
						prices.set(z-1, a);
						prices.set(z, b);
					}
					z--;
				}
			}
		}
		
		//get the first price which is the least and turn it into a String
		double leastPrice = prices.get(0);
		String sNewPrice = Double.toString(leastPrice);
		
		//placeholders for Product object so it can be initialized
		String name = "n";
		String price = "p";
		String type = "t";
		Product leastExpProd = new Product(name, price, type);
		
		//for each loop to go through the product array and find the one with the same price
		for(Product prod: items) {
			if(sNewPrice.equals(prod.getProductPrice())) {
				leastExpProd = prod;
				break;
			}
		}
		
		//return the product with lowest price
		return leastExpProd;
	}
	
	//method to find most expensive item
	public static Product findMostExpensiveItem(Store store) {
		
		//follows the same process as findLeastExpensiveItem() except this one is for highest price
		ArrayList<Product> items = new ArrayList<Product>();
		items = store.getItemsInStock();
		items.remove(0);
		
		ArrayList<Double> prices = new ArrayList<Double>();
		
		for(Product prod: items) {
			String sPrice = prod.getProductPrice();
			double num = Double.parseDouble(sPrice);
			prices.add(num);
		}
		
		for(int i = 0; i < prices.size()-1; i++){
			double x, y;
			x = prices.get(i);
			y = prices.get(i+1);
									
			if(x > y) {
				prices.set(i, y);
				prices.set(i+1, x);
				int z = i;
				while(z > 0) {
					double a = prices.get(z);
					double b = prices.get(z-1);
					if(a < b) {
						prices.set(z-1, a);
						prices.set(z, b);
					}
					z--;
				}
			}
		}
					
		double mostPrice = prices.get(prices.size()-1);
		String sNewPrice = Double.toString(mostPrice);
		
		String name = "n";
		String price = "p";
		String type = "t";
		
		Product mostExpProd = new Product(name, price, type);
		for(Product prod: items) {
			if(sNewPrice.equals(prod.getProductPrice())) {
				mostExpProd = prod;
				break;
			}
		}
		
		return mostExpProd;
	}
	
	//method for creating lists of customers based on their membership
	public static ArrayList<Customer> customerType (Store store, boolean chooseCustomerType) {
		
		//create an array to store the customer information
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers = store.getCustomerList();
		
		//if the requested membership type passed as a method parameter is false (as in "not a member")
		if(chooseCustomerType == false) {
			//for loop to remove all members (those with a "true" value) from the array
			for(int i = 0; i < customers.size(); i++) {
				Customer customer = customers.get(i);
				if(customer.isMember() == true) {
					customers.remove(customer);
					i--;
				}
			}
		} 
		//else if the requested membership type is true (as in "a member")
		else if (chooseCustomerType == true) {
			//for loop to remove all non-members (those with a "false" value) from the array
			for(int i = 0; i < customers.size(); i++) {
				Customer customer = customers.get(i);
				if(customer.isMember() == false) {
					customers.remove(customer);
					i--;
				}
			}
		}
		
		//return the edited array of customers
		return customers;
	}
	

	//main method
	public static void main(String[] args) throws Exception {
		//create necessary arrays and variables
		ArrayList<Product> allProd = new ArrayList<Product>();
		ArrayList<Customer> allCustomers = new ArrayList<Customer>();
		Product product1;
		Customer customer1;
		
		//read PRODUCT information from a CSV file and place in an array
		//have to download file and replace the file path information
		Scanner prod = new Scanner(new File("C:\\Users\\Ruqayyah\\normalJava\\SustainableShopping\\walmartShopList.csv"));
		prod.useDelimiter(",|\r?\n");
		
		while(prod.hasNextLine()) {
			product1 = new Product(prod.next(), prod.next(), prod.next());
			allProd.add(product1);
		}
		
		prod.close();
		
		//read CUSTOMER information from a CSV file and place in an array
		URL uC = new URL("https://raw.githubusercontent.com/ladyrukky/Shopping/main/customerData.csv");
		Scanner customer = new Scanner(uC.openStream());
		customer.useDelimiter(",|\r?\n");
		
		while(customer.hasNextLine()) {
			customer1 = new Customer(customer.nextInt(), customer.next(), customer.nextLong(), customer.next(), customer.nextBoolean());
			allCustomers.add(customer1);
		}
				
		customer.close();
		
		//create new Store with product and customer information
		Store store1 = new Store("Walmart", allProd, allCustomers);
			    
		//find least and most expensive products
	    System.out.println("The least expensive product in this " + store1.getStoreName() + " is: \n" + findLeastExpensiveItem(store1) + "\n\n");
	    System.out.println("The most expensive product in this " + store1.getStoreName() +  " is: \n" + findMostExpensiveItem(store1));

	    
	    //attempt to test customerType() method (below)
	    //for some reason, whenever I try this section of the code, it doesn't print the array of customers
	    //I tried debugging further up to see what is in the array of allCustomers (lines 186 to 191)
	    //but once it is out of the while loop, it stops showing the customer information
	    
	    //Scanner to take in user response
	    Scanner keyboard = new Scanner(System.in);
	    System.out.print("\n---------\n\nDo you want to see customers that are members? Enter 'Y' or 'N': ");
	    String response = keyboard.next();
	    
	    //if response is yes
	    if(response.equals("Y") || response.equals("y")) {
	    	//should return customers who are members
	    	System.out.println("\nThese customers are members of " + store1.getStoreName() + ": ");
	    	System.out.println(customerType(store1, true).toString());
	    }
	    //if response is no
	    else if(response.equals("N") || response.equals("n")) {
	    	//should return customers who are not members
	    	System.out.println("\nThese customers are not members of " + store1.getStoreName() + ": ");
	    	System.out.println(customerType(store1, false).toString());
	    }
	    //if response is not Y or N
	    else {
	    	//ask for proper input
	    	System.out.print("\nPlease enter either 'Y' or 'N': ");
		    response = keyboard.next();
	    }
	    
	    keyboard.close();
	    
	}

}
