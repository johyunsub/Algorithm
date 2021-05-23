import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 맥주마시면서걸어가기_9205 {
	static int N, cnt = 0;
	static boolean ans;
	static boolean[] v;
	static ArrayList<int[]> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			list = new ArrayList<int[]>();	//좌표들을 리스트에 넣어서 관리 (모든 좌표를 검사하지않고 시작점, 편의점, 도착점의 노드 좌표만 관리)
			N = sc.nextInt(); //편의점 개수
			v = new boolean[N+2];	//방문체크배열로써 모든 좌표를 체크하지않고 특정노드의 개수만큼만 생성하고 방문체크 관리를 한다.
			ans = false;
			for(int i=0; i<N+2; i++){
				int[] tmp = new int[2];	//리스트에 넣은 임시배열 선언 
				tmp[0] = sc.nextInt();	//행
				tmp[1] = sc.nextInt();	//열
				list.add(tmp);	//배열리스트의 첫원소는 출발점, N-1번째까지 원소:편의점, N번 째원소:페스티벌 
			}
			//리스트의 첫번째 원소인 시작점 행과 열좌표, 마지막 원소인 도착점의 행과 열좌표를 파라미터로 던져줌
			bfs(list.get(0)[0], list.get(0)[1], list.get(N+1)[0], list.get(N+1)[1]);	
			//ans가 true이면 happy를 출력 아니면 sad를 출력
			if(ans)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
	private static void bfs(int r, int c, int fr, int fc) {
		Queue<Data1> q = new LinkedList<Data1>();	//큐선언
		q.offer(new Data1(r, c));	//큐생성
		v[0] = true;	//시작점 방문체크
		while(!q.isEmpty()) {	
			Data1 tmp = q.poll();	//큐에서 꺼냄
			
			if(tmp.r==fr && tmp.c==fc) {		//큐에서 꺼낸 노드가 도착점일 경우
				ans = true;		//ans를 true로 설정
				return;
			}
			for(int i=1; i<N+2; i++) {		//리스트에서의 편의점 원소와 도착점 원소들을 하나씩 비교 
				int lr = list.get(i)[0];	//i번째 원소의 행
				int lc = list.get(i)[1];	//i번째 원소의 열
				if(v[i]) continue;			//i번째 원소가 이미 방문한 원소이면 스킵
				//큐에서 꺼낸 원소의 좌표와 리스트의 i번째원소와의 거리가 1000이하일 때만 큐에 넣음
				if(Math.abs(lr - tmp.r) + Math.abs(lc - tmp.c) <= 1000) {	
					q.add(new Data1(lr, lc));	//리스트의 i번째 원소 큐에 넣음
					v[i] = true;	//i번째 원소 방문 체크
				}
			}
		}
	}
}

class Data1{
	int r, c;
	public Data1(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

