package com.java.first;

public class CircleArea {

	public static void main(String[] args) {
		
		int radius = 5;
		final double pi = 3.14;
		
		double Area = radius * radius * pi;
		System.out.printf("반지름이 5Cm인 원의 넓이는 %.2fCm2입니다." ,Area);
	}
}
