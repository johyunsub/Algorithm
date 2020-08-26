import java.util.Scanner;


public class 오목 {
	static int r=0,c=0,res=0;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = { 0, 1, 1, 1, 0,-1,-1,-1}; //상,우상,우,우하,하,좌하,좌,좌상
	static int[] dy = {-1,-1, 0, 1, 1, 1, 0,-1};
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		map = new int[19][19];
		v = new boolean[19][19];
		
		//맵 생성
		for(int i=0; i<19; i++) {
			String str = sc.nextLine().replace(" ", "");
			for(int j=0; j<19; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		
		loop: for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(map[i][j] == 0) continue;
				if(map[i][j] == 1) {	//첫번째 흑돌 발견!
					// 상하좌우 확인
					for(int d=0; d<8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						//범위 내에 있을 때
						if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
							continue;
						}
						
						//두번째 돌이 첫번 째 돌의 d방향으로 흑돌일 경우!
						if(map[nx][ny] == 1) {	//다음,그다음번째,,, 돌들도 같은 색 돌인지 
							int nx3 = nx + dx[d];
							int ny3 = ny + dy[d];
							//범위 내에 있을 때
							if(nx3 < 0 || nx3 >= 19 || ny3 < 0 || ny3 >= 19) {
								continue;
							}
							//세번째 돌이 두번 째 돌의 d방향으로 흑돌일 경우
							if(map[nx3][ny3] == 1) {
								int nx4 = nx3 + dx[d];
								int ny4 = ny3 + dy[d];
								//범위 내에 있을 때
								if(nx4 < 0 || nx4 >= 19 || ny4 < 0 || ny4 >= 19) {
									continue;
								}
								//네번째 돌이 세번 째 돌의 d방향으로 흑돌일 경우
								if(map[nx4][ny4] == 1) {
									int nx5 = nx4 + dx[d];
									int ny5 = ny4 + dy[d];
									//범위 내에 있을 때
									if(nx5 < 0 || nx5 >= 19 || ny5 < 0 || ny5 >= 19) {
										continue;
									}
									//5번째 돌까지 흑돌이면 반복문 탈출!
									if(map[nx5][ny5] == 1) {
										r = i+1;
										c = j+1;
										res = 1;
										break loop;
									}
								}
							}
						}
					}
				}
				
				//백돌의 경우
				if(map[i][j] == 2) {
					// 상하좌우 확인
					for(int d=0; d<8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						//범위 내에 있을 때
						if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
							continue;
						}
						
						//두번째 돌이 첫번 째 돌의 d방향으로 백돌일 경우!
						if(map[nx][ny] == 2) {	//다음,그다음번째,,, 돌들도 같은 색 돌인지 
							int nx3 = nx + dx[d];
							int ny3 = ny + dy[d];
							//범위 내에 있을 때
							if(nx3 < 0 || nx3 >= 19 || ny3 < 0 || ny3 >= 19) {
								continue;
							}
							if(map[nx3][ny3] == 2) {
								int nx4 = nx3 + dx[d];
								int ny4 = ny3 + dy[d];
								//범위 내에 있을 때
								if(nx4 < 0 || nx4 >= 19 || ny4 < 0 || ny4 >= 19) {
									continue;
								}
								if(map[nx4][ny4] == 2) {
									int nx5 = nx4 + dx[d];
									int ny5 = ny4 + dy[d];
									//범위 내에 있을 때
									if(nx5 < 0 || nx5 >= 19 || ny5 < 0 || ny5 >= 19) {
										continue;
									}
									if(map[nx5][ny5] == 2) {
										r = i+1;
										c = j+1;
										res = 2;
										break loop;
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(res);
		System.out.println(r + " " + c);
		
		//bfs();
	}
	
}
