package com.java.first;

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int mul = num1 * num2;
		int div;
		if(num1 > num2) 
			div = num1/num2;
		else
			div = num2/num1;
		System.out.printf("곱=%d\n몫=%d", mul, div);

	}
}
