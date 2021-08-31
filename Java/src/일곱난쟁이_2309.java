import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_2309 {
	static int[] small9;
	static int[] small7;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		small9 = new int[9];
		small7 = new int[7];
		for(int i=0; i<9; i++) {
			small9[i] = sc.nextInt();
		}
		
		combi(0,0);
	}
	private static void combi(int cnt, int start) {
		if(cnt == 7) {
			int sum=0;
			for(int i=0; i<7; i++) {
				sum += small7[i];
			}
			if(sum == 100) {
				Arrays.sort(small7);
				for(int i=0; i<7; i++) {
					System.out.println(small7[i]);
				}
			}
			return;
		}
		for(int i=start; i<9; i++) {
			small7[cnt] = small9[i];
			combi(cnt+1, i+1);
		}
	}

}
