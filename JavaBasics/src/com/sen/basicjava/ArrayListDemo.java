package com.sen.basicjava;

import java.util.ArrayList;

public class ArrayListDemo {

	
	String UserID;
	String empname;
	String address1;
	String address2;
	String postalcode;
	String phonenum;

	public    ArrayListDemo(String ID,
	String name,
	String add1,
	String add2,
	String pc,
	String pn) {
		
		UserID = ID;
		empname = name;
		address1 = add1;
		address2 = add2;
		postalcode = pc;
		phonenum = pn;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayListDemo> al = new ArrayList<ArrayListDemo>();
		
		ArrayListDemo d1 = new ArrayListDemo("0001","Senthil Bala","8633 Srpingmont Ln","keller","76244","9495272364");
		ArrayListDemo d2 = new ArrayListDemo("0002","Senthil Bala2","8633 Srpingmont Ln","keller","76244","9495272364");
		
		al.add(d1);
		al.add(d2);
		
	
	for (ArrayListDemo val:al) {
		
		System.out.println(val.UserID);
		System.out.println(val.empname);
		System.out.println(val.address1);
		System.out.println(val.address2);
		System.out.println(val.postalcode);
		System.out.println(val.phonenum);
		
	}

	}

}
