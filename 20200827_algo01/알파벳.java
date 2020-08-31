import java.util.Scanner;

public class 알파벳 {
	static int R,C;
	static char[][] map;
	static boolean[] check;
	static int[] dx = { 0, 1, 0,-1};
	static int[] dy = {-1, 0, 1, 0};
	static int max;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		String str;
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			str = sc.nextLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		check = new boolean[26];
		
		
		max = 0;
		flag = false;
		check[map[0][0]-'A'] = true;
		dfs(0,0,1);
		System.out.println(max);
		max = 0;	
	}
	
	
	private static void dfs(int x, int y, int cnt) {
		max = Math.max(max, cnt);	
		if(flag)
			return;
		if(cnt == 26) {	//모든 알파벳이 다 방문되어 있을 떄
			flag = true;
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx<0 || nx>=C || ny<0 || ny>=R) {
				continue;
			}
			
			//방문했던 알파벳이면
			if(check[map[ny][nx]-'A']) {
				continue;
			}
			check[map[ny][nx]-'A'] = true;
			dfs(nx, ny, cnt+1);
			check[map[ny][nx]-'A'] = false;
			
		}
		
	}	

}
