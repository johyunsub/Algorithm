import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 파핑파핑지뢰찾기_1868 {
	static int N, ans;
	static char map[][];
	static int[] dr = {-1,-1, 0, 1, 1, 1, 0,-1};
	static int[] dc = { 0, 1, 1, 1, 0,-1,-1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) map[i][j] = str.charAt(j);
			}  //입력끝
			ans = 0; //지뢰가 있는 칸을 제외한 다른 모든 칸의 숫자들이 표시되려면 최소의 클릭 횟수
			for (int i = 0; i < N; i++)  
				for (int j = 0; j < N; j++) 
					if(map[i][j] != '*') map[i][j] = aroundMine(i, j); //칸마다 주변에 지뢰의 갯수를 map에 표시  
			for (int i = 0; i < N; i++)  
				for (int j = 0; j < N; j++) 
					if(map[i][j] == '0') bfs(i, j); //주변에 지뢰가 하나도 없다면 0인 구역을 포함한 한칸 인접 구역까지 지뢰로 표시
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++) 
					if(map[i][j] != '*') ans++;  //map에 남아있는 수들은 클릭해봐야 지뢰여부를 알 수 있으므로 칸마다 횟수 1증가
			System.out.println("#"+t+" "+ans);
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r, c});  
		map[r][c] = '*';  //map에 지뢰표시(방문체크 개념으로 지뢰를 표시한 구역은 다음에 방문하지 않도록 하기 위함)
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int d=0; d<8; d++) {  //8방위 탐색
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				if(nr>=N || nc>=N || nr<0 || nc<0) continue;  //map을 넘어가는 영역 제외
				if(map[nr][nc] == '*') continue;  //지뢰면 방문할 필요없음
				if(map[nr][nc] != '0') { //map에 0이 아닌 숫자라면 지뢰로 표시(0의 인접한 구역은 지뢰로 표시)
					map[nr][nc] = '*';  //지뢰로 표시
					continue;
				}
				q.offer(new int[] {nr, nc});  //0인 구역을 q에 넣고
				map[nr][nc] = '*';  //지뢰로 표시
			}
		} ans++;  //bfs한번 탈때마다 횟수 1증가
	}

	private static char aroundMine(int r, int c) { //칸마다 주변 지뢰의 갯수를 map에 표시하는 메서드
		int cnt = 0;  //지뢰의 갯수
		for(int d=0; d<8; d++) {  //8방위 탐색
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=N || nc>=N || nr<0 || nc<0) continue;
			if(map[nr][nc] == '*')  //주변 지뢰의 갯수마다 cnt 1증가
				cnt++;
		}
		return (char) ('0' + cnt); //주변 지뢰 갯수 반환
	}
}