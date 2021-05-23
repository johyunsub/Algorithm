import java.util.Arrays;
import java.util.Scanner;
public class Religion {
	static int N, M;
	static int[] p;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		makeSet();
		
		for(int k=0; k<M; k++) {
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			
			union(i, j);			
		}
		
		int cnt =0;
		for(int a=0; a<p.length; a++) {
			if(findSet(a) == a) {
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println(Arrays.toString(p));
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x != y) {
			p[y] = x;
		}
	}
	static int findSet(int x) {
		if(x == p[x]) {
			return x;
		}
		p[x] = findSet(p[x]);
		return p[x];
	}
	private static void makeSet() {
		p = new int[N];
		for(int i = 0 ; i < N; i++) {
			p[i] = i;
		}
	}
}
