import java.util.Scanner;

public class 알파벳_1987 {
	static int R, C;
	static char[][] map;
	static boolean[] visited = new boolean[26];	//방문한 알파벳 배열
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int totCount = 0;
	static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); C = sc.nextInt();
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = sc.next();
			for(int j=0; j<C; j++) 
				map[i][j] = str.charAt(j);
		}
		
		visited[map[0][0]-65] = true;
		dfs(0,0,1);
		System.out.println(totCount);
	}
	
	private static void dfs(int r, int c, int count) {
		totCount = Math.max(totCount, count);
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<R && nc<C && nr>=0 && nc>=0) {
				int nextAlpha = map[nr][nc]-65;	//다음 자리의 알파벳
				if(!visited[nextAlpha]) {		//방문 안했을때 
					visited[nextAlpha] = true;	//방문체크
					dfs(nr, nc, count+1);		//다음 자리 넘어감
					visited[nextAlpha] = false;	//돌아가면서 그자리 방문 취소
				}
			}
		}
	}
}
