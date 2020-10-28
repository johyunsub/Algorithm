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
			}//입력
			
			int ans = 0;	//건설 가능한 경우의 가로행 or 세로열의 합 
			boolean b = false;	//건설할지 말지 정하는 변수
			
			//가로 행 위에서부터 아래로 검색
			for(int i=0; i<N; i++) {
				boolean f = true;	//flag변수로서 모든 조건을 충족하게되면 true로 ans를 증가하도록 함
				boolean[] v = new boolean[N];	//활주로가 지어져있는지 행or열 단위로 판단하는 방문체크배열
				for (int j=0; j<N; j++) { 
					if(j+1 >= N) continue;	//범위를 벗어날 경우는 스킵
					
					if(map[i][j] == map[i][j+1]) continue;	//다음 땅이 평지일 경우
					
					else if(Math.abs(map[i][j] - map[i][j+1]) > 1)  f = false;	//다음 땅과의 경사가 2이상인 경우는 제외
						
					else if(map[i][j] > map[i][j+1]) {	//다음 땅이 내리막길인 경우
						for(int k=j+1; k<j+X+1; k++) {	//k는 활주로의 길이만큼 반복
							b = false;	//최초 활주로의 건설 여부는 false로 초기화
							if(k >= N) {  //범위가 벗어나게되면 지을수 있는 활주로의 길이도 벗어나므로 flag를 false로 하고 탈출
								f = false; 
								break; 
							}
							if(map[i][j+1] != map[i][k]) {	//평지가 아니므로 활주로를 지을 수 없기에 flag를 false로 하고 탈출
								f = false;
								break;
							}
							if(v[k]) {	//활주로가 이미 건설되어 있으면 제외 flag를 false로 하고 탈출
								f = false;
								break;
							}
							b = true;	//모든 조건을 충족하면 활주로 건설 가능이므로 true
						}
						if(b) {	//활주로를 건설가능 하다면  활주로 길이만큼 방문체크
							for(int k=j+1; k<j+X+1; k++) {
								if(k >= N) continue;
								if(!v[k]) {	//방문체크
									v[k] = true;
								}
							}
						}
					}//내리막길end
					
					else if(map[i][j] < map[i][j+1]) {	//오르막길인 경우
						for(int k=j; k>j-X; k--) {
							b = false;
							if(k < 0) { 
								f = false; 
								break; 
							}
							if(map[i][j] != map[i][k]) {
								f = false;
								break;
							}
							if(v[k]) {	//이미 건설되어 있으면 제외
								f = false;
								break;
							}
							b = true;
						}
						if(b) {
							for(int k=j; k>j-X; k--) {
								if(k < 0) continue;
								if(!v[k]) {	//방문체크
									v[k] = true;
								}
							}
						}
					}//오르막길end
				}
				
				if(f) {	//모든 경우를 충족시킬때 지을 수 있는 행or열을 1증가
					ans++;
				}
			}
			
			//세로 검색
			for(int j=0; j<N; j++) {
				boolean f = true;
				boolean[] v = new boolean[N];
				for (int i=0; i<N; i++) {
					if(i+1 >= N) continue;
					if(map[i][j] == map[i+1][j]) {
						continue;
					}
					else if(Math.abs(map[i][j] - map[i+1][j]) > 1)
						f = false;
					else if(map[i][j] > map[i+1][j]) {
						for(int k=i+1; k<i+X+1; k++) {
							b = false;
							if(k >= N) { 
								f = false; 
								break; 
							}
							if(map[i+1][j] != map[k][j]) {
								f = false;
								break;
							}
							if(v[k]) {	//이미 건설되어 있으면 제외
								f = false;
								break;
							}
							b = true;
						}
						
						if(b) {
							for(int k=i+1; k<i+X+1; k++) {
								if(k >= N) continue;
								if(!v[k]) {	//방문체크
									v[k] = true;
								}
							}
						}
					}
					else if(map[i][j] < map[i+1][j]) {
						for(int k=i; k>i-X; k--) {
							b = false;
							if(k < 0) { 
								f = false; 
								break; 
							}
							if(map[i][j] != map[k][j]) {
								f = false;
								break;
							}
							if(v[k]) {	//이미 건설되어 있으면 제외
								f = false;
								break;
							}
							b = true;
						}
						
						if(b) {
							for(int k=i; k>i-X; k--) {
								if(k < 0) continue;
								if(!v[k]) {	//방문체크
									v[k] = true;
								}
							}
						}
					}
					
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
