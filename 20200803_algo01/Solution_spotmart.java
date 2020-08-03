import java.util.Scanner;

public class Solution_spotmart {
	private static int N,M, R=2, sum, max=0;
	private static int[] numbers, input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int test_case=1; test_case<=t; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			numbers = new int[N];
			input = new int[N];
			
			for(int i=0; i<N; i++) {
				input[i] = sc.nextInt();
			}
			max = 0;
			combination(0, 0);
			if(max == 0)
				max = -1;
			System.out.println("#" + test_case + " " + max);			
		}
	}
	
	//중복조합
	private static void combination(int cnt, int start) {
		if(cnt == R) {
			sum = 0;
			for(int i=0; i<numbers.length; i++) {	//조합의 합
				sum += numbers[i]; 
			}	
			if(sum <= M && max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
}
