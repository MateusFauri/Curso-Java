package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	Date moment;
	OrderStatus status;
	Client client;
	List <OrderItem> items = new ArrayList<>();
	
	/*
		#####Metodos#####
	*/
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		
		for(OrderItem item : items) {
			sum += item.subTotal();
		}
		
		return sum ;
	}
	
	/*
		#####Constructors#####
	 */
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	/*
		#####Getters and Setters####
	 */
	
	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Oder moment: " + sdf1.format(moment) + "\n");
		sb.append("Order status:" + status + "\n");
		sb.append("Client (" + client.getName() + ") ");
		sb.append(sdf.format(client.getBirthDate()) + " - ");
		sb.append(client.getEmail());
		sb.append("\nOrder Items: \n");
		for(OrderItem item: items) {
			sb.append(item.product.getName());
			sb.append(", Quantity: " + item.getQuantity());
			sb.append(", Subtotal: " + item.subTotal() );
			sb.append("\n");
		}
		sb.append("Total price: " + total());
		
		
		return sb.toString();
		
	}

	
	
}
