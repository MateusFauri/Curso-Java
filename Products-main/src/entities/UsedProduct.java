package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date manufactureDate;
	

	
	@Override
	public final String priceTag() {
		return name
				+ "(used) $"
				+ String.format("%.2f", price)
				+ " (Manufacture Date: "
				+ sdf.format(manufactureDate)
				+")";
	}

	
	
	public UsedProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}



	public Date getManufactureDate() {
		return manufactureDate;
	}



	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	

}