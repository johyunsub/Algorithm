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
		
		int halfn = n/2;	//�� ��и� ����
		
		if(r < halfn && c < halfn) {	//1��и�
			dfs(r, c, halfn);
		}
		if(r < halfn && c >= halfn) {	//2��и�
			count += halfn * halfn;
			dfs(r, c-halfn, halfn);	//���� ��и鿡�� ����� r,c�� ����
		}
		if(r >= halfn && c < halfn) {	//3��и�
			count += 2 * halfn * halfn;
			dfs(r-halfn, c, halfn);
		}
		if(r >= halfn && c >= halfn) {	//4��и�
			count += 3 * halfn * halfn;
			dfs(r-halfn, c-halfn, halfn);
		}
	}

	
}
