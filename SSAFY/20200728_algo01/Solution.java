import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			int start = 1;
			int last = N*N;
			
			int i =0, j=0;
			int width = N;
			int length = N-1;
			
			while(start <= last) {
				for(int k=0; k<width; k++) {
					snail[i][j] = start;
					j++;
					start++;
				}
				width--;
				i++;
				j--;
				for(int k=0; k<length; k++) {
					snail[i][j] = start;
					i++;
					start++;
				}
				length--;
				i--;
				j--;
				for(int k=0; k<width; k++) {
					snail[i][j] = start;
					j--;
					start++;
				}
				width--;
				i--;
				j++;
				for(int k=0; k<length; k++) {
					snail[i][j] = start;
					i--;
					start++;
				}
				length--;
				i++;
				j++;
			}
			
			for(int a=0; a<snail.length; a++) {
				for(int b=0; b<snail[a].length; b++) {
					System.out.print(snail[a][b] + " ");
				}
				System.out.println();
			}
			
		}
	}
}
