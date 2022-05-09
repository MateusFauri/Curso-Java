package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.Product;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			System.out.println("Enter a directory path: ");
			String strDirectoryPath = sc.nextLine();
			File directoryPath = new File(strDirectoryPath);
			
			File[] files = directoryPath.listFiles(File::isFile);
			System.out.println("Files: ");
			System.out.println();
			for(File f : files) {
				System.out.println("	" + f.getName());
			}
			
			System.out.println();
			System.out.print("Do you want creat a new file (Y/N): ");
			char newFile = sc.next().charAt(0);
			
			File path = null;
			
			if(newFile == 'y') {
				System.out.print("File name(.csv): ");
				String fileName = sc.next(); 
				String newFilePath = strDirectoryPath + "\\" + fileName ;
				path = new File(newFilePath);
				
			}
			else {
				System.out.print("Which file do you want read/modify: ");
				String strFile = sc.next();
				String strPath = strDirectoryPath + "\\" + strFile ;
				path = new File(strPath);
			}
	
	
			List<Product> list = new ArrayList<>();
			
			boolean success = new File( strDirectoryPath + "\\out").mkdir();
			if(success)
				System.out.println("Folder make whit success!");
			String newPathCSV = path.getParent() + "\\out\\summary.csv";
			
			System.out.print("Do you need add more itens (Y/N)? ");
			char answer = sc.next().charAt(0);
			
			if(answer == 'y') {
				try {
					System.out.print("how many itens do you want creat?");
					int n = sc.nextInt();
					for(int i=0; i<n; i++) {
						System.out.print("Name: ");
						sc.nextLine();
						String nameNew = sc.nextLine();
						System.out.print("Price: ");
						double priceNew = sc.nextDouble();
						System.out.print("Quantity: ");
						int quantityNew = sc.nextInt();
		
						try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
							bw.append(nameNew + ";" + priceNew + ";" + quantityNew );
							bw.newLine();
						}
						catch(IOException e) {
							System.out.println("Error: " + e.getMessage());
						}
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Error: " + e.getMessage());
				}
	
			}
			
			try(BufferedReader br = new BufferedReader(new FileReader(path))){
				String line = br.readLine();
				
				while(line != null) {
					String[] lineSplit = line.split(";");
					String name = lineSplit[0];
					double price = Double.parseDouble(lineSplit[1]);
					int quantity = Integer.parseInt(lineSplit[2]);
					
					list.add(new Product(name, price, quantity));
					
					line = br.readLine();
				}
			
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(newPathCSV))){
					for(Product item : list) {
						bw.append(item.getName() + ";" + String.format("%.2f",item.totPrice()));
						bw.newLine();
					}
					
					System.out.println(newPathCSV + " Created!");
				}
				catch(IOException e) {
					System.out.println("Error: " + e.getMessage());
				}
			
			
			}
			catch(IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally{
			sc.close();
		}
		
	}

}
