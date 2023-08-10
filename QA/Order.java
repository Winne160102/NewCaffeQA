package QA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	private String name;
	private String size;
	private String ice;
	private String sugar;
	private String topping;
	private String price;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(String name, String size, String ice, String sugar, String topping) {
		super();
		this.name = name;
		this.size = size;
		this.ice = ice;
		this.sugar = sugar;
		this.topping = topping;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public void inputOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Name: ");
		name = sc.nextLine();
		System.out.println("Input Size: ");
		size = sc.nextLine();
		System.out.println("Input Ice: ");
		ice = sc.nextLine();
		System.out.println("Input Sugar: ");
		sugar = sc.nextLine();
		System.out.println("Input Topping: ");
		topping = sc.nextLine();
		
	}

	public static void outputFileBill(ArrayList<Order> list){
		try {
			FileWriter fWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\lib java\\Bill.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Order data : list) {
				bWriter.write(data.getName() + data.getSize() + ";" + data.getIce() + ";" + data.getSugar() + ";" + data.getTopping());
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Order> inputFileBill() {
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			FileReader fReader = new FileReader("C:\\\\Users\\\\Admin\\\\Desktop\\\\lib java\\\\Order.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String line = bReader.readLine();
				if(line == null || line == "") break;
				String[] temp = line.split("[;]");
				Order data = new Order(temp[0], temp[1], temp[2], temp[3], temp[4]);
				list.add(data);
			}
			bReader.close();
			fReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void outputFileOrder(ArrayList<Order> list ) {
		Order od = new Order();
		Scanner sc = new Scanner(System.in);
		try {
			FileWriter fWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\lib java\\Order.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
		    boolean exit = false;
		    while (!exit) {
		    	od.inputOrder();
		        bWriter.write(od.name + ";" + od.size + ";" + od.ice + ";" + od.sugar + ";" + od.topping);
		        bWriter.newLine();	
		        System.out.println("Do you want to order more? (Y/N)");
		        String choice = sc.nextLine();  
		        if (choice.equalsIgnoreCase("N")) {
		            exit = true;
		        } else if (!choice.equalsIgnoreCase("Y")) {
		          System.out.println("Please choose again!");
		        } 
		    }
			bWriter.close();
			fWriter.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void choiceQA() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Order> list = new ArrayList<Order>();
		boolean exit = false;
		System.out.println("Enter Your Choice: 1 - Order Your Drink, 2 - Print Bill, 3 - Complete The Purchase.");
		while (!exit) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				outputFileOrder(list);
				System.out.println("Order Has Been Completed");
				break;
			case 2:
				outputFileBill(list);
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Invalid Choice!");
				break;
			}
		}
	}
	public static void main(String[] args) {
		 Order od = new Order();
		 od.choiceQA();
	}
}
