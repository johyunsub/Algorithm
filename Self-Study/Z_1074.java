import java.util.Scanner;

public class Z_1074 {
	static int N, R, C, count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int) Math.pow(2, sc.nextInt());
		R = sc.nextInt();
		C = sc.nextInt();
		
		dfs(R, C, N);
		System.out.println(count);
	}
	private static void dfs(int r, int c, int n) {
		if(n == 1)	return;
		
		int halfn = n/2;	//한 사분면 길이
		
		if(r < halfn && c < halfn) {	//1사분면
			dfs(r, c, halfn);
		}
		if(r < halfn && c >= halfn) {	//2사분면
			count += halfn * halfn;
			dfs(r, c-halfn, halfn);	//다음 사분면에서 적용될 r,c값 조정
		}
		if(r >= halfn && c < halfn) {	//3사분면
			count += 2 * halfn * halfn;
			dfs(r-halfn, c, halfn);
		}
		if(r >= halfn && c >= halfn) {	//4사분면
			count += 3 * halfn * halfn;
			dfs(r-halfn, c-halfn, halfn);
		}
	}

	
}
