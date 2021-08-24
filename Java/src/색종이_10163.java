import java.util.Scanner;

public class 색종이_10163 {
	static int N;
	static int[] cnt;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = new int[N];
		map = new int[101][101];
		for(int k=1; k<=N; k++) {
			int r = sc.nextInt();	//행좌표
			int c = sc.nextInt();	//열좌표
			int w = sc.nextInt();	//너비
			int h = sc.nextInt();	//높이
			
			for(int i=r; i<r+w; i++) {
				for(int j=c; j<c+h; j++) {
					if(map[i][j] > 0) {
						cnt[map[i][j]-1]--;
					}					
					cnt[k-1]++;
					map[i][j] = k;
				}
			}
		}
		for(int i=0; i<N; i++) {
			if(cnt[i] <= 0)
				System.out.println(0);
			else
				System.out.println(cnt[i]);
		}
	}
}
