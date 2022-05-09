package application;


import java.io.File;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import entities.Files;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			System.out.println("Enter a directory path: ");
			String strDirectoryPath = sc.nextLine();
			File directoryPath = new File(strDirectoryPath);
			
			boolean success = new File( strDirectoryPath + "/out").mkdir();
			if(success)
				System.out.println("Folder make whit success!");
			
			String outPathCSV = strDirectoryPath + "/out/summary.csv";
			
			
			Files.showFiles(directoryPath);
			System.out.println();
			
			String path;
			System.out.print("Do you want creat a new file (Y/N): ");
			char newFile = sc.next().charAt(0);
			if(newFile == 'y') {
				System.out.print("File name(.csv): ");
				String fileName = sc.next(); 
				Files.createNewFile(strDirectoryPath, fileName);  
				path = strDirectoryPath + "/" + fileName;
				
			}
			else {
				System.out.print("Which file do you want read/modify: ");
				String nameFile = sc.next();
				path = strDirectoryPath + "/" + nameFile;
				
			}
			
			
			System.out.print("Do you need add more itens (Y/N)? ");
			char answer = sc.next().charAt(0);
			if(answer == 'y') {
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
			
					Files.writeInFile(nameNew, priceNew, quantityNew, path);
					}
			}
					
			Files.readFileAndWriteInAnotherFile(path, outPathCSV);
		}
		catch(InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally{
			sc.close();
		}
		
	}

}

