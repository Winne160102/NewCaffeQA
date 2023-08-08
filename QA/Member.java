package QA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Member extends People {
	private String idMember;

	//get & set attributes
	public String getIdMember() {
		return idMember;
	}

	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}
	//constructor 
	public Member() {
		super();
	}
	//constructor all attributes
	public Member(String id, String name, String birthday, String phoneNum, String address, String idMember) {
		super(id, name, birthday, phoneNum, address);
		this.idMember = idMember;
	}
	//set all attributes
	public void setall(String id, String name, String birthday, String phoneNum, String address, String idMember) {
		super.setall(id, name, birthday, phoneNum, address);
		this.idMember = idMember;
	}
	//input Member 
	public void inputMember() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Input ID Member: ");
		idMember = sc.nextLine();
	}
	//output Member
	public void outputMember() {
		super.output();
		System.out.println("ID Member: " + getIdMember());
	}
	//inputFile Member
	public static ArrayList<Member> inputFileMember() {
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			FileReader fReader = new FileReader("/Users/belle/eclipse-workspace/NewBtap/src/QA/inputFilePeople.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String line = bReader.readLine();
				if(line == null || line == "") break;
				String[] temp = line.split("[;]");
				if(temp[5].substring(0,2).equals("tv")) {
					Member data = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
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
	//outputFile Member
	public static void outputFileMember(ArrayList<Member> list) {
		try {
			FileWriter fWriter = new FileWriter("/Users/belle/eclipse-workspace/NewBtap/src/QA/Member.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Member data : list) {
				bWriter.write(data.getId() + ";" + data.getName() + ";" + data.getBirthday() + ";" + data.getBirthday()  + ";" + data.getPhoneNum() + ";" + data.getAddress() + ";" + data.getIdMember());
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();
		list = inputFileMember();
		outputFileMember(list);
	}
}
