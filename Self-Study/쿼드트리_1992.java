import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÄõµåÆ®¸®_1992 {
	static int N;
	static int[][] img;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		img = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				img[i][j] = str.charAt(j) - '0';
			}
		}
		sb = new StringBuilder();
		sb.append("(");
		dfs(0, 0, N);
		
	}
	private static StringBuilder dfs(int r, int c, int n) {
		if(n == 1) {
			sb.append(img[r][c]);
			return sb;
		}
		
		StringBuilder d1 = dfs(r, c, n/2);
		if(d1.equals("0000"))
				d1.
		StringBuilder d2 = dfs(r, c+n/2, n/2);
		StringBuilder d3 = dfs(r+n/2, c, n/2);
		StringBuilder d4 = dfs(r+n/2, c+n/2, n/2);
		
		
		
		return d4;
		
		
	}

}
