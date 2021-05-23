package com.ssafy.hw.step03;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int strider = 0;
		
		for(int t=0; t<tc; t++) {
			int N = sc.nextInt();	//연못 크기
			int cnt = sc.nextInt();	//마릿수
			int x, y, v;
			
			boolean[][] pond = new boolean[N][N];
		
			for(int i=0; i<cnt; i++) {
				y = sc.nextInt();	
				x = sc.nextInt();	
				v = sc.nextInt();
				
				switch(v) {
				case 1: 
					//상
					if(x>=N || y>=N || pond[y][x]==true) //범위를 벗어나거나 충돌시 
						continue;
					else if(y-3<0 || pond[y-3][x]==true) 
						continue;
					else if(y-5<0 || pond[y-5][x]==true)
						continue;
					else if(y-6<0 || pond[y-6][x]==true)
						continue;
					
					pond[y-6][x] = true;
					break;
					
				case 2:
					//하
					if(x>=N || y>=N || pond[y][x]==true)
						continue;
					else if(y+3>=N || pond[y+3][x]==true) 
						continue;
					else if(y+5>=N || pond[y+5][x]==true)
						continue;
					else if(y+6>=N || pond[y+6][x]==true)
						continue;
					
					pond[y+6][x] = true;
					break;
					
				case 3:
					//좌
					if(x>=N || y>=N || pond[y][x]==true) 
						continue;
					else if(x-3<0 || pond[y][x-3]==true) 
						continue;
					else if(x-5<0 || pond[y][x-5]==true)
						continue;
					else if(x-6<0 || pond[y][x-6]==true)
						continue;
					
					pond[y][x-6] = true;
					break;
					
				case 4:
					//우
					if(x>=N || y>=N || pond[y][x]==true) 
						continue;
					else if(x+3>=N || pond[y][x+3]==true) 
						continue;
					else if(x+5>=N || pond[y][x+5]==true)
						continue;
					else if(x+6>=N || pond[y][x+6]==true)
						continue;
					
					pond[y][x+6] = true; 
					break;
				}
			}
	
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(pond[i][j] == true)
						strider++;
				}
			}
			
			System.out.println("#"+ (t+1)+ " " + strider);
			strider = 0;
		}
	}
}
