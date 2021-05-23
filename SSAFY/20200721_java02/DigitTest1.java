package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int [10]; //10의 자리 숫자 저장
		
		while(true) {
			int N = sc.nextInt();
			if(N == 0) {
				break;
			}
			
			if(N/10 == 0)
				arr[0]++;
			else if(N/10 == 1)
				arr[1]++;
			else if(N/10 == 2)
				arr[2]++;
			else if(N/10 == 3)
				arr[3]++;
			else if(N/10 ==4)
				arr[4]++;
			else if(N/10 == 5)
				arr[5]++;
			else if(N/10 == 6)
				arr[6]++;
			else if(N/10 == 7)
				arr[7]++;
			else if(N/10 == 8)
				arr[8]++;
			else
				arr[9]++;
		}
		
		for(int j=0; j<arr.length; j++) {
			if(arr[j]>0)
				System.out.println(j+ " : " + arr[j] + "개");
		}
	}
}
