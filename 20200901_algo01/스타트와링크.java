import java.util.Scanner;

public class 스타트와링크 {
	static int N,R,sum1=0, sum2=0, min=100000;
	static boolean[] team;	//true인 팀, false인 팀
	static 	int[][] spec;	//선수 능력치
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = N/2;
		team = new boolean[N];
		spec = new int[N][N];	

		for(int i=0; i<N; i++) {	
			for(int j=0; j<N; j++) {
				spec[i][j] = sc.nextInt();
			}
		}
		
		combination(0,0);	//두팀으로 나눌 선수를 3명씩 뽑아야 하므로 조합 이용
		System.out.println(min);
	}
	
	private static void combination(int cnt,int start) {
		if(cnt == R) {	//뽑은 팀에 대하여 true인 팀과 false인 팀으로 나뉘게 된다.
			int abs = 0;
			for(int i=0; i<N; i++) {	
				for(int j=0; j<N; j++) {
					if(team[i] && team[j]) {	//true인 팀에 대하여 i번째 선수와 j번째 선수가 같은 팀일 경우 
						sum1 += spec[i][j];		//능력치를 합한다.
					}
					if(!team[i] && !team[j]) {	//false인 팀에 대하여 i번째 선수와 j번째 선수가 같은 팀일 경우 
						sum2 += spec[i][j];		//능력치를 합한다.
					}
				}
			}
			abs = Math.abs(sum1-sum2);		//true팀과 false팀의 능력치 차이를 계산
			min = Math.min(abs, min);		//능력치 차이의 최소를 찾는다.
			sum1 = sum2 = 0;				//또 다른 경우의 팁이 뽑아야 하므로 능력치합 초기화
			return;
		}
		for(int i=start; i<N; ++i) {	
			team[i] = true;
			combination(cnt+1,i+1);
			team[i] = false;
		}
	}
}
