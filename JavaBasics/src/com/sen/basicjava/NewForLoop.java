package com.sen.basicjava;

public class NewForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i[] = new int[101];
		
		for (int n=0;n<=100;n++) {
			
			i[n] = n;
			
			
		}
		
		for (int nf:i) {
			
			System.out.println(nf);
			
		}
		
		
	}

}
