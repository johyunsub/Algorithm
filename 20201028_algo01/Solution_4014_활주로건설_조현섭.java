import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_조현섭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			boolean[][] v = new boolean[N][N];
			for(int i=0; i<N; i++) {
				boolean f = true;
				for (int j=0; j<N; j++) {
					if(j+1 >= N) continue;
					if(map[i][j] == map[i][j+1]) {
						continue;
					}
					else if(map[i][j] > map[i][j+1]) {
						for(int k=j+1; k<j+X+1; k++) {
							if(k >= N)  break;
							if(map[i][j+1] != map[i][k]) {
								f = false;
								break;
							}
							if(v[i][j]) {	//이미 건설되어 있으면 제외
								f = false;
								break;
							}
								
							if(!v[i][k]) {	//방문체크
								v[i][k] = true;
							}
						}
					}
					else if(map[i][j] < map[i][j+1]) {
						for(int k=j-1; k<j-X-1; k--) {
							if(k < 0)  break;
							if(map[i][j-1] != map[i][k]) {
								f = false;
								break;
							}
							if(v[i][j]) {	//이미 건설되어 있으면 제외
								f = false;
								break;
							}
								
							if(!v[i][k]) {	//방문체크
								v[i][k] = true;
							}
						}
					}
					else if(Math.abs(map[i][j] - map[i][j+1]) > 1)
						f = false;
				}
				if(f) {
					ans++;
				}
			}
			
			v = new boolean[N][N];
			for(int j=0; j<N; j++) {
				boolean f = true;
				for (int i=0; i<N; i++) {
					if(j+1 >= N) continue;
					if(map[i][j] == map[i][j+1]) {
						continue;
					}
					else if(map[i][j] > map[i][j+1]) {
						for(int k=j+1; k<j+X+1; k++) {
							if(k >= N)  break;
							if(map[i][j+1] != map[i][k]) {
								f = false;
								break;
							}
							if(v[i][j]) {	//이미 건설되어 있으면 제외
								f = false;
								break;
							}
								
							if(!v[i][k]) {	//방문체크
								v[i][k] = true;
							}
						}
					}
					else if(map[i][j] < map[i][j+1]) {
						for(int k=j-1; k<j-X-1; k--) {
							if(k < 0)  break;
							if(map[i][j-1] != map[i][k]) {
								f = false;
								break;
							}
							if(v[i][j]) {	//이미 건설되어 있으면 제외
								f = false;
								break;
							}
								
							if(!v[i][k]) {	//방문체크
								v[i][k] = true;
							}
						}
					}
					else if(Math.abs(map[i][j] - map[i][j+1]) > 1)
						f = false;
				}
				if(f) {
					ans++;
				}
			}
			
			System.out.print("#" + t + " " + ans);
			System.out.println();
		}
	}

}
