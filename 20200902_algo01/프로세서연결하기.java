package day0902;

import java.util.Scanner;

//배열의 달팽이 순회 방식으로 겉에서 부터 안쪽으로 탐색하면서 코어를 발견하게 된다면 수선의 발을 놓는 형식으로 구현하도록 함.
//반례-> 제약사항 3 (최대한 많은 Core에 전원을 연결해도, 전원이 연결되지 않는 Core가 존재할 수 있다)을 충족시키지 못함
public class 프로세서연결하기 {
	static int N, len;
	static int[][] map;
	public static int[] dr = {-1,1,0,0};	//상하좌우
	public static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t=0; t<tc; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			for(int i=0; i<N; i++) {	//map 입력받기
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int s=1, e=N-1;
			for(int k=1; k<N/2; k++) {		//깊이
				for(int j=s; j<e; j++) {	//가로
					if(map[k][j] == 1) {	//윗가로
						
						go(k, j, 0);	//case 0
					}
					if(map[N-1-k][j] == 1) {	//아랫가로
						go(N-1-k, j, 1);	//case 1
					}
				}
				for(int i=s+1; i<e-1; i++) {	//세로
					if(map[i][k] == 1) {		//왼세로
						go(i, k, 2);	//case 2
					}
					if(map[i][N-1-k] == 1) {	//오른세로
						go(i, N-1-k, 3);	//case 3
					}
				}
				s++;
				e--;
			}
			if(N%2 == 1)
				if(map[N/2][N/2] == 1) {
					for(int d=0; d<4; d++) {
						if(isAvailable(N/2,N/2,d)) {	//사방위검색
							setStatus(N/2,N/2,d,2);
							break;
						}
					}
				}
					
			
			
			System.out.println(len);
			len=0;
		}
	}
	
	private static void go(int k, int j, int d) {
		switch(d) {
		case 0:
			if(isAvailable(k,j,0)) {	//상검색
				setStatus(k,j,0,2);
				break;
			}
			if(j<N/2) {
				if(isAvailable(k,j,2)) {	//좌검색
					setStatus(k,j,2,2);
					break;
				}
				if(isAvailable(k,j,3)) {	//우검색
					setStatus(k,j,3,2);
					break;
				}
			}else {
				if(isAvailable(k,j,3)) {	//우검색
					setStatus(k,j,3,2);
					break;
				}
				if(isAvailable(k,j,2)) {	//좌검색
					setStatus(k,j,2,2);
					break;
				}
			}
			if(isAvailable(k,j,1)) {	//하검색
				setStatus(k,j,1,2);
				break;
			}
			break;
		case 1:
			if(isAvailable(k,j,1)) {	//하검색
				setStatus(k,j,1,2);
				break;
			}
			if(j<N/2) {
				if(isAvailable(k,j,2)) {	//좌검색
					setStatus(k,j,2,2);
					break;
				}
				if(isAvailable(k,j,3)) {	//우검색
					setStatus(k,j,3,2);
					break;
				}
			}else {
				if(isAvailable(k,j,3)) {	//우검색
					setStatus(k,j,3,2);
					break;
				}
				if(isAvailable(k,j,2)) {	//좌검색
					setStatus(k,j,2,2);
					break;
				}
			}
			if(isAvailable(k,j,0)) {	//상검색
				setStatus(k,j,0,2);
				break;
			}
			break;
		case 2:
			if(isAvailable(k,j,2)) {	//좌검색
				setStatus(k,j,2,2);
				break;
			}
			if(k>N/2) {
				if(isAvailable(k,j,1)) {	//하검색
					setStatus(k,j,1,2);
					break;
				}
				if(isAvailable(k,j,0)) {	//상검색
					setStatus(k,j,0,2);
					break;
				}
			}else {
				if(isAvailable(k,j,0)) {	//상검색
					setStatus(k,j,0,2);
					break;
				}
				if(isAvailable(k,j,1)) {	//하검색
					setStatus(k,j,1,2);
					break;
				}
			}
			if(isAvailable(k,j,3)) {	//우검색
				setStatus(k,j,3,2);
				break;
			}
			break;
		case 3:
			if(isAvailable(k,j,3)) {	//우검색
				setStatus(k,j,3,2);
				break;
			}
			if(k>N/2) {
				if(isAvailable(k,j,1)) {	//하검색
					setStatus(k,j,1,2);
					break;
				}
				if(isAvailable(k,j,0)) {	//상검색
					setStatus(k,j,0,2);
					break;
				}
			}else {
				if(isAvailable(k,j,0)) {	//상검색
					setStatus(k,j,0,2);
					break;
				}
				if(isAvailable(k,j,1)) {	//하검색
					setStatus(k,j,1,2);
					break;
				}
			}
			if(isAvailable(k,j,2)) {	//좌검색
				setStatus(k,j,2,2);
				break;
			}
			break;
		}
	}

	// 현코어의 위치에서 해당 방향으로 전선을 놓는게 가능한지 체크
	private static boolean isAvailable(int r,int c,int d) {
		int nr=r,nc=c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N)break; // 가장자리까지 다 전선을 놓을수 있는 상황
			if(map[nr][nc]>=1) return false; // 1: 코어, 2: 전선	
		}
		return true;
	}
	// 현코어의 위치에서 해당 방향으로 전선을 놓거나(s=2) 지우는(s=0) 셋팅
	private static void setStatus(int r,int c,int d,int s) {
		int nr=r,nc=c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N)break;
			map[nr][nc] = s;
			len++;
		}
	}
	

}
