import java.util.Scanner;

public class 바이러스 {
	static int N, K, cnt;	//N:총 컴퓨터 수, K:네트워크 쌍의 수, cnt:1번컴퓨터와 감염된 컴퓨터 수
	static boolean[] visit;	//방문처리 배열
	static boolean[][] adj;	//네트워크의 인접행렬 그래프
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visit = new boolean[N];	//방문체크 배열 생성
		adj  = new boolean[N][N];	//인접행렬 그래프 생성
		for(int i=0; i<K; i++) {	//그래프 채우기
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a-1][b-1] = adj[b-1][a-1] = true;	//우상 좌하 대칭 
		}
		cnt = 0;	//감염된 컴퓨터 수 초기화
		dfs(0);		//dfs방식으로 그래프 탐색 
		System.out.println(cnt);	//1번 컴퓨터와 감염된 컴퓨터의 수를 출력
	}
	private static void dfs(int v) {	//v번 컴퓨터를 인자 값으로 함
		visit[v] = true;	//v번 컴퓨터 방문체크
		for(int i=0; i<N; i++) {	
			if(adj[v][i] && !visit[i]) {	//v번 컴퓨터와 i번 컴퓨터가 연결되어 있는지 & i번 컴퓨터는 방문안했는지
				cnt++;	//연결 횟수 1증가
				dfs(i);	//인접해 있는 i번 컴퓨터에서 탐색
			}
		}
	}
}
