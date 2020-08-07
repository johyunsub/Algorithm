import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Homes {
	static int[][] homes;
	static int N, danji =0;
	static int[]large;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		homes = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String a = sc.next();
			for(int j=0; j<N; j++) {
				homes[i][j] = (a.charAt(j) - '0');
			}
		}
		
		large = new int[N*N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(homes[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
//		Arrays.sort(list);
		
		//리스트 오름차순 정렬
		Collections.sort(list);
		
		System.out.println(danji);
		for(int i=0; i<danji; i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	
	
	static void bfs(int i, int j) {
		Queue<Data> q = new LinkedList<Data>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		Data cur;
		int cnt=0;
		
		homes[i][j] = 0;	//방문체크
		cnt++;
		Data temp = new Data(i, j);
		q.offer(temp);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			//사방위 탐색
			for(int k=0; k<4; k++) {
				int nx = cur.x + dx[k]; 
				int ny = cur.y + dy[k];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) 
					continue;
				
				if(homes[nx][ny] == 0) 
					continue;
				
				temp = new Data(nx, ny);
				q.offer(temp);
				homes[nx][ny] = 0;
				cnt++;
			}
		}
		list.add(cnt);
		danji++;
		
	}
	
	
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
