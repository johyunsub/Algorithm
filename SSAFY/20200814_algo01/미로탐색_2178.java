import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};	//시계방향탐색
	static int[] dc = { 0, 1, 0,-1};
	static Queue<Data> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		sc.nextLine();
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs(0,0);
	}
	private static void bfs(int r, int c) {
		q = new LinkedList<Data>();		//큐생성
		visit[r][c] = true;	//시작 좌표 방문체크
		
		q.offer(new Data(r, c, 1));	//출발점부터 시작
		while(!q.isEmpty()) {	//큐가 비었을 때까지 반복
			Data tmp = q.poll();	//큐에서 꺼내고 임시변수tmp에 저장
			
			if(tmp.r == N-1 && tmp.c == M-1) {	//도착했는지?
				System.out.println(tmp.cnt);
				return;
			}
			
			for(int d=0; d<4; d++){	//tmp좌표기준 시계방향 탐색
				int nr = tmp.r + dr[d];	//다음 이동할 좌표
				int nc = tmp.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)	//범위 벗어나면 continue
					continue;
				if(map[nr][nc] == 0)	//벽이면 continue
					continue;
				
				if(!visit[nr][nc]) {	//방문하지 않은 곳들의 다음 위치를 큐에 넣음
					q.offer(new Data(nr, nc, tmp.cnt+1));	//tmp.cnt를 끌고다니면서 +1해서 던져줌
					visit[nr][nc] = true;	//다음 방문할 곳 미리 방문체크!!! 
				}
			}
		}
		return;
	}
}
class Data{	//좌표의 객체
	int r, c, cnt;
	public Data(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}
