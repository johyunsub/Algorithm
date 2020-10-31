import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 시게방향으로  v가  0:상, 1:우, 2:하, 3:좌
 * 시계방향의 오른쪽은 +1을 하면 되고 
 * 시계방향의 왼쪽은 -1을 하면 된다.
 */
public class 뱀_3190 {
	static int N, K, L, nr=0, nc=0, op[][], map[][];
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = { 0, 1, 0,-1};
	static boolean turn = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = -1;
		}
		L = Integer.parseInt(br.readLine());
		op = new int[L][2];  //1열: 명령을 할 시간을 저장, 2열: 명령어 저장(D 또는 L)
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			op[i][0] = Integer.parseInt(st.nextToken());  //명령을 할 시간을 저장
			op[i][1] = st.nextToken().charAt(0)=='L' ? -1 : 1;  //왼쪽이면 -1, 오른쪽이면 +1
		}//입력end

		Queue<int[]> q = new LinkedList<int[]>();  //좌표값을 배열로 관리하는 큐 생성  
		int time=0, opidx=0, v=1, r=0, c=0;  //시간, op배열의 index, 방향, 행, 열 
		q.offer(new int[] {0, 0});  //시작점 큐에 넣음
		
		while(!q.isEmpty()) {
			time++;  //시간 증가
			int nr = r + dr[v], nc = c + dc[v];  //설정된 방향으로 다음좌표 값 설정
			
			if(nr>=N || nc>=N || nr<0 || nc<0 ) break;  //벽에 부딪힐 경우
			
			if(map[nr][nc] == 1) break;  //자기자신을 물 경우
			
			if(map[nr][nc] == 0) { //이동할 곳에 아무것도 없는 경우
				map[nr][nc] = 1;  //뱀의 머리를 놓고
				q.offer(new int[] {nr, nc});  //큐에 좌표 넣음
				int[] tmp = q.poll();  //꼬리의 좌표부분 큐에서 삭제
				map[tmp[0]][tmp[1]] = 0;  //꼬리의 좌표부분 map에서 제거
			}
			else if(map[nr][nc] == -1) { //사과가 있는 경우
				map[nr][nc] = 1;  //뱀의 머리를 놓음
				q.offer(new int[] {nr, nc});  //머리부분 좌표 큐에 추가
			}
			if(opidx < L && op[opidx][0] == time) {  //해당시간에 맞는 명령어 실행(방향만 설정)
				v += op[opidx][1];  //명령에 맞는 방향 설정
				if(v<0) v += 4;  //4방위 범위 넘어가면 재설정
				if(v>3) v -= 4;
				opidx++;  //다음 명령 받기
			}
			r = nr;  //다음 좌표 설정
			c = nc;
		}
		System.out.println(time);  //시간 출력
	}
}
