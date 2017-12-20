
package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

import guiTeacher.components.TextField;


public class CatalogMaker {
	
	private ArrayList<Grocery> list; 
	
	public CatalogMaker() {
		list= new ArrayList<Grocery> ();
		list.add(new Grocery("Tomato", 5));
		list.add(new Grocery("Carrot", 15));
		list.add(new Grocery("Cucumber", 7));
	}

	public String getCsvContent(){
		String data = "description, price \n";
		for(Grocery g : list) {
			data += g + "\n";
		}
		return data;
	}
	public void addNewItem(TextField descriptionField, TextField priceField) {
		list.add(new Grocery(descriptionField, priceField));
		System.out.println("Item added successfully.");
	}
	public static void main(String[] args) {
		
		CatalogMaker x = new CatalogMaker();
		
		Scanner input = new Scanner(System.in);
		
		while(input.nextLine() != "stop") {
			System.out.println("Please enter a description");
			String description = input.nextLine();
			System.out.println("Now enter a price.");
			double price = input.nextInt();
		}
		System.out.println((x.getCsvContent()));
	}
}




