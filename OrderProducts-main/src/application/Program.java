package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY):");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		
		System.out.println();
		System.out.println("Enter Order data: ");
		System.out.print("Status: ");
		String status = sc.next();	
		
		Date now = new Date();		
		Order order = new Order(now, OrderStatus.valueOf(status),client);
		
		
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		for(int i=1; i <= items; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String pName = sc.next();
			System.out.print("Product price: ");
			double pPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int pQuantity = sc.nextInt();
			
			Product product = new Product(pName, pPrice);
			OrderItem orderItem = new OrderItem(pQuantity, pPrice,product);
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		
		
		sc.close();
	}

}
