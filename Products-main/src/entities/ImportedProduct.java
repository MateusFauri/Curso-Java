package entities;

public class ImportedProduct extends Product {

	private Double customsFee;
	
	@Override
	public final String priceTag() {
		return name
				+ "(used) $"
				+ String.format("%.2f", totalPrice())
				+ " (Customs Fee: $"
				+ String.format("%.2f", customsFee)
				+ ")";
		
	}

	
	public double totalPrice() {
		return price + customsFee;
	}
	
	public ImportedProduct() {
		super();
	}


	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
		
	
}
