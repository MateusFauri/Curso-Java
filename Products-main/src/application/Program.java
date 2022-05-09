package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> productList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i=1; i<=n; i++) {
			
			System.out.println("Product #"+i+" data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(c == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				productList.add(new ImportedProduct(name,price, customsFee));
				
			}else if (c == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date dateManufacture = sdf.parse(sc.next());
				productList.add(new UsedProduct(name, price, dateManufacture) );
				
			}else if (c == 'c') {
				Product p1 = new Product(name,price);
				productList.add(p1);
			}

		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for(Product ls : productList) {
			System.out.println(ls.priceTag());
		}
		

		
		
		sc.close();
	}

}
