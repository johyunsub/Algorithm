import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 치즈도둑 {
	static int N, ans, tcnt, max;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { 1, 0,-1, 0};
	static int[] dc = { 0, 1, 0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			ans = max = 0;
			for(int i=0; i<N; i++) 	
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);	//치즈중에 맛있는 정도가 가장 큰 값(100일까지 안돌도록 가지치기)
				}
			for(int day=0; day<=max; day++) {	//0일부터 가장 맛있는 정도까지만 반복
				v = new boolean[N][N]; tcnt = 0;	//방문체크배열; 덩어리의 개수
				for(int i=0; i<N; i++) 
					for(int j=0; j<N; j++) 
						if(map[i][j] <= day)
							v[i][j] = true;	//맛있는 부분을 제외한 덩어리 찾기
						
				for(int i=0; i<N; i++) 
					for(int j=0; j<N; j++) 
						if(!v[i][j]) 
							bfs(i, j); tcnt++;	//덩어리 찾기
				ans = Math.max(ans, tcnt);	//day마다 가장 큰 덩어리 개수 찾기
			}
			System.out.printf("#%d %d", t, ans);
			System.out.println();
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<Data> q = new LinkedList<Data>();
		q.offer(new Data(r, c));
		v[r][c] = true;	//방문체크
		
		while(!q.isEmpty()) {
			Data tmp = q.poll();
			for(int d=0; d<4; d++) {
				int nr = tmp.r + dr[d];
				int nc = tmp.c + dc[d];
			
				if(nr>=N || nc>=N || nr<0 || nc<0) continue;
				if(v[nr][nc]) continue;	//이미 방문한것은 제외
				
				q.offer(new Data(nr, nc));
				v[nr][nc] = true;
			}
		}
	}
}

class Data {
	int r, c;
	public Data(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
