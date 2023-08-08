package QA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Drink {
	private String id;
	private String name;
	private float price;
	//constructor
	public Drink() {
	}
	//constructor all attributes
	
	//get & set attributes
	public Drink(String id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	//input Drink
	public void inputDrink() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input ID Drink: ");
		id = sc.nextLine();
		System.out.println("Input Name Drink: ");
		name = sc.nextLine();
		System.out.println("Input Price Drink: ");
		price = sc.nextFloat();
		while(price < 0) {
			System.out.println("Error, Please Input Price Drink Again!! ");
			price = sc.nextFloat();
		}
	}
	//output Drink
	public void outputDrink() {
		System.out.println("ID Drink: " + getId());
		System.out.println("Name Drink: " + getName());
		System.out.println("Price Drink: " + getPrice());
	}
	//inputFile Drink
	public static ArrayList<Drink> inputFileDrink() {
		ArrayList<Drink> list = new ArrayList<Drink>();
		try {
			FileReader fReader = new FileReader("/Users/belle/eclipse-workspace/NewBtap/src/QA/Drink.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String line = bReader.readLine();
				if(line == null || line == "") break;
				String[] temp = line.split("[;]");
				Drink data = new Drink(temp[0], temp[1], Float.parseFloat(temp[2]));
				list.add(data);
			}
			bReader.close();
			fReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//outputFile Drink
	public static void outputFileDrink(ArrayList<Drink> list) {
		try {
			FileWriter fWriter = new FileWriter("/Users/belle/eclipse-workspace/NewBtap/src/QA/Drinkout.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Drink data : list) {
				bWriter.write(data.getId() + ";" + data.getName() + ";" + data.getPrice());
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ArrayList<Drink> list = new ArrayList<Drink>();
		list = inputFileDrink();
		outputFileDrink(list);
	}
}
