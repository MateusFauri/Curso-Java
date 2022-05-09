package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Files {

	
	
	public static void createNewFile(String directory, String fileName) {
		String path = directory + "/" + fileName;  //this for linux, need to change for windows and mac if possible
		try{
			new File(path).createNewFile();
			System.out.println("File Created whit success!");
		}catch(IOException e) {
			System.out.println("Error: can't creat this file." );
		}
	}
	
	public static void writeInFile(String name, double price, int quantity, String path) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			bw.append(name + ";" + price + ";" + quantity);
			bw.newLine();
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public static void showFiles(File directoryPath) {
		File[] files = directoryPath.listFiles(File::isFile);
		System.out.println("Files: ");
		System.out.println();
		for(File f : files) {
			System.out.println("	" + f.getName());
		}
	}
	
	public static void readFileAndWriteInAnotherFile(String path, String outPathCSV) {
		List<Product> list = new ArrayList<>();
		
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
		
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(outPathCSV))){
				for(Product item : list) {
					bw.append(item.getName() + ";" + String.format("%.2f",item.totPrice()));
					bw.newLine();
				}
				
				System.out.println(outPathCSV + " Created!");
			}
			catch(IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		
		
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	
	
	
}
