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
	public static ArrayList<Order> inputFileOrder(){
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			FileReader fReader = new FileReader("C:\\Users\\Admin\\Desktop\\lib java\\order.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String line = bReader.readLine();
				if (line == "" || line == null) break;
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
	
	public static void outputFileOrder(ArrayList<Order> list) {
		try {
			FileWriter fWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\lib java\\Order.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for (Order data : list) {
				bWriter.write(data.getName() + ";" + data.getSize() + ";" + data.getIce() + ";" + data.getSugar() + ";" + data.getTopping());
				bWriter.newLine();
			}
			 Scanner sc = new Scanner(System.in);
		        System.out.println("Input Name: ");
		        String name = sc.nextLine();
		        System.out.println("Input Size: ");
		        String size = sc.nextLine();
		        System.out.println("Input Ice: ");
		        String ice = sc.nextLine();
		        System.out.println("Input Sugar: ");
		        String sugar = sc.nextLine();
		        System.out.println("Input Topping: ");
		        String topping = sc.nextLine();
		        bWriter.write(name + ";" + size + ";" + ice + ";" + sugar + ";" + topping);
		        bWriter.newLine();
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void choice() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Order> list = new ArrayList<Order>();
		boolean exit = false;
		System.out.println("Enter Your Choice: 1 - Input File, 2 - Output File, 3 - Enter Information For Order, 4 - Exit.");
		while (!exit) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				list = inputFileOrder();
				System.out.println("Input File Created. ");
				break;
			
			case 2:
				outputFileOrder(list);
				System.out.println("Output File Created. ");
				break;
		
			case 3:
				exit = true;
				System.out.println("Program has been closed.");
				break;
				
			default:
				System.out.println("Invalid Choice!");
				break;
			}
		}
	}
	public static void main(String[] args) {
		 Order od = new Order();
		 od.choice();
	}
}
