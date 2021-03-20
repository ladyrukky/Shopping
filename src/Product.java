
public class Product {

	private String productName;
	private String productPrice;
	private String productType;
	
	public Product() {}
	
	public Product(String productName, String productPrice, String productType) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Name: " + productName + "\nPrice: "
				+ productPrice + "\nKeywords: " + productType;
	}
}
