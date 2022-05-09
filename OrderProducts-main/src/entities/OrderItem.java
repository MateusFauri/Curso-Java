package entities;

public class OrderItem {
	
	Integer quantity;
	Double price;
	
	Product product;
	
	public double subTotal() {
		return quantity * price;
	}

		//Constructors
	
	public OrderItem(Integer quantity, Double price, Product product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	public OrderItem() {
		
	}

		//GETTERS AND SETTERS
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
