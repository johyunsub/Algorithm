import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장_1952 {
	static int res;
	static int[] charge = new int[4];
	static int[] month = new int[12];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) 
				charge[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<12; i++) 
				month[i] = Integer.parseInt(st.nextToken());
			
			res = charge[3];  //1년치 계산한 값을 최소값으로 시작
			dfs(0,0);  
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static void dfs(int m, int cost) {
		if(m>11) {  //모든 경우에서 12달까지 계산한 값들 중에서 최소값을 저장
			res = Math.min(res, cost);
			return;
		}
		if(month[m] == 0)  //사용하지 않는 달은 스킵
			dfs(m+1, cost);
		if(cost > res) {  //12달까지 계산하기 전에 이미 비싸버린 경우는 가지치기
			return;
		}
			
		dfs(m+1, cost + charge[0]*month[m]);  //하루치를 계산한 값
		dfs(m+1, cost + charge[1]);  //한달치를 계산한 값
		dfs(m+3, cost + charge[2]);  //세달치를 계산한 값
	}
}
