package QA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends People {
	private String idStaff;
	private String wage;
// constructor 
	public Staff() {
		super();
		
	}
// constructor all attributes
	public Staff(String id, String name, String birthday, String phoneNum, String address, String idStaff, String wage) {
		super(id, name, birthday, phoneNum, address);
		this.idStaff = idStaff;
		this.wage = wage;
	}
// get & set attributes
	public String getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
// set all attributes
	public void setall(String id, String name, String birthday, String phoneNum, String address, String idStaff, String wage) {
		super.setall(id, name, birthday, phoneNum, address);
		this.idStaff = idStaff;
	}
//
//input from keyboard
	public void inputStaff() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Input Id Staff: ");
		idStaff = sc.nextLine();
		System.out.println("Input Wage: ");
		wage = sc.nextLine();
	}
//output from keyboard
	public void outputStaff() {
		super.output();
		System.out.println("ID Staff: " + getIdStaff());
		System.out.println("Wage: " + getWage());		
	}
//inputStaff File
	public static ArrayList<Staff> inputFileStaff(){
		ArrayList<Staff> list = new ArrayList<Staff>();
		try {
			FileReader fReader = new FileReader("/Users/belle/eclipse-workspace/NewBtap/src/QA/inputFilePeople.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String line = bReader.readLine();
				if(line == "" || line == null) break;
				String[] temp = line.split("[;]");
				if((temp[5].substring(0,2)).equals("nv")) {
					Staff data = new Staff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
					list.add(data);
				}
			}
			bReader.close();
			fReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
//outputStaff File
	public static void outputFileStaff(ArrayList<Staff> list) {
		try {
			FileWriter fWriter = new FileWriter("/Users/belle/eclipse-workspace/NewBtap/src/QA/Staff.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Staff data : list) {
				String tempStaff = data.getIdStaff();
				bWriter.write(data.getId() + ";" + data.getName() + ";" + data.getBirthday() + ";" + data.getPhoneNum() + ";" + data.getAddress() + ";" + data.getIdStaff() + ";" + data.getWage());
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ArrayList<Staff> list = new ArrayList<Staff>();
		list = inputFileStaff();
		outputFileStaff(list);
	}
}
