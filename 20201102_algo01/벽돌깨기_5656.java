import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽돌깨기_5656 {
	static int N, W, H, min, map[][];
	private static int[] dr = {-1,1,0,0}; 
	private static int[] dc = {0,0,-1,1}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			int total = 0;
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for (int j=0, index=0; j<W; j++, index+=2) {
					map[i][j] = str.charAt(index)-'0';
					if(map[i][j] > 0) total++;
				}
			}
			min = Integer.MAX_VALUE;
			dfs(0, total, map);
			System.out.println("#"+t+" "+min);
		}
	}
	private static void dfs(int cnt, int remainCnt, int[][] map) {
		if(remainCnt == 0) {
			min = 0;
			return;
		}
		if(cnt == N) {  //N횟수가 되었을 때 리턴
			if(min > remainCnt) min = remainCnt;  //최솟값을 남은 벽돌의 갯수
			return;
		}
		int[][] cMap = new int[H][W];  //복사할 map생성
		for(int j=0; j<W; j++) {
			int i = 0;
			while(i<H && map[i][j]==0) i++;  //0은 건너뛰기
			if(i == H) continue;  //바닥이면 다음열
			
			copy(cMap, map); //map을 복사해두고 복사된 map에 작업하고 재귀에 태움
			
			int boomCnt = boom(cMap, i, j);  //벽돌 터트리기
			
			down(cMap);  //벽돌 사이 공백제거
			
			dfs(cnt+1,remainCnt-boomCnt, cMap);  //다음횟수로 재귀태움
			
		}
		
	}
	static ArrayList<Integer> list = new ArrayList<Integer>();
	private static void down(int[][] map) { 
		for (int c = 0; c < W; c++) { // 열고정 
			int r;
			for ( r = H-1; r >= 0; r--) {
				if(map[r][c]>0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			r = H;
			for (int b : list) {
				map[--r][c] = b;
			}
			list.clear();
		}
	}
	private static int boom(int[][] map, int r, int c) {
		int cnt = 0;
		Queue<Data> q = new LinkedList<Data>();
		if(map[r][c]>1) {
			q.offer(new Data(r,c,map[r][c]));
		}
		map[r][c] = 0;  //벽돌 제거 처리(방문처리)
		cnt++;
		
		while(!q.isEmpty()) {
			Data tmp = q.poll();
			for(int d=0; d<4; d++) {
				int nr = tmp.r, nc = tmp.c;
				for(int k=1; k<tmp.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] != 0) {
						if(map[nr][nc]>1) {
							q.offer(new Data(nr, nc,map[nr][nc]));
						}
						map[nr][nc] = 0;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	
	private static void copy(int[][] cMap, int[][] map) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				cMap[i][j] = map[i][j];
			}
		}
	}
	
	static class Data{
		int r,c,cnt;
		public Data(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

}
