package QA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

public class People {

	public String id;
	public String name;
	public String birthday;
	public String phoneNum;
	public String address;
	
	public People() {
	}
	
	public People(String id, String name, String birthday, String phoneNum, String address) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.phoneNum = phoneNum;
		this.address = address;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setall(String id, String name, String birthday, String phoneNum, String address) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input ID: ");
		id = sc.nextLine();
		System.out.print("Input Name: ");
		name = sc.nextLine();
		System.out.print("Input Birthday: ");
		birthday = sc.nextLine();
		System.out.print("Input Phone Number: ");
		phoneNum = sc.nextLine();
		System.out.print("Input Address: ");
		address = sc.nextLine();
	}
	public void output() {
		System.out.println("ID: " + getId());
		System.out.println("Name: " + getName());
		System.out.println("Birthday: " + getBirthday());
		System.out.println("Phone Number: " + getPhoneNum());
		System.out.println("Address: " + getAddress());
	}
	
}
