import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기_1759 {
	static int L, C;
	static char[] pw, input;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		input = new char[C];
		v = new boolean[C];
		pw = new char[L];
		char[] tmp = sc.nextLine().toCharArray();
		for(int i=0, j=0; i<C; i++, j+=2) 
			input[i] = tmp[j];
		Arrays.sort(input);
		dfs(0, 0, 0);
		
		
	}
	private static void dfs(int count, int e, int f) {
		if(count == L) {
			if(e >= 1 && f >= 2) {
				System.out.println(Arrays.toString(pw));
				return;
			}
			 
		}
		for(int i=count; i<count+C; i++) {
			if(i<L && !v[i]) {
				pw[count] = input[i];
				if(isMoum(input[i])) {
					v[i] = true;
					dfs(count+1, e+1, f);
				}
				else {
					v[i] = true;
					dfs(count+1, e, f+1);
				}
				v[i] = false;
			}
			
		}
		
	}
	private static boolean isMoum(char alpha) {
		switch(alpha) {
		case 97:
			return true;
		case 101:
			return true;
		case 105:
			return true;
		case 111:
			return true;
		case 117:
			return true;
		default:
			return false;
		}
	}

}
