import java.util.Scanner;

public class 회전초밥 {
	static int N, d, k, c;
	static int[]  sushi;
	static int[] ate;	//먹은 것 체크 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//총 접시수
		d = sc.nextInt();	//초밥 가짓수
		k = sc.nextInt();	//연속해서 먹는 수
		c = sc.nextInt();	//쿠폰 번호
		
		sushi = new int[N];
		ate = new int[d+1];

		int cnt=0;
		
		for(int i=0; i<N; i++) {
			sushi[i] = sc.nextInt();
		}
		
		int max = 0;
		
		int e;
		ate[c] = 1;
		cnt = 1;
		
		for(int s=0; s<k; s++) {	//k까지 셋팅
			if(ate[sushi[s]]++>0) {	//먹어본 초밥(or 쿠폰초밥)일 경우 먹은 횟수 1증가
				continue;
			}
			cnt++;
		}
		max = cnt;
		
		//슬라이딩 윈도우 기법
		for(int s=1; s<N; s++) {	//윈도우마다 cnt를 계산해 가장 큰값 찾기
			e = s+k-1;	//끝을 가리킴
			if(e >= N) {	//범위를 초과했을 경우 (회전판은 원형이므로 배열의 끝을 넘어서면 배열의 처음으로 이어줌)
				e = e-N;
			}
			
			//범위 내
			if(ate[sushi[e]] <= 0) {	//안 먹어본 초밥일 경우
				cnt++;
			}
			ate[sushi[e]]++;	//다음 윈도우의 먹어본 초밥 개수 1증가
			ate[sushi[s-1]]--;	//이전 윈도우의 먹어본 초밥 개수 1감소
			if(ate[sushi[s-1]] <= 0)	//먹어본 초밥을 제거 할 때 초밥의 개수가 0개가 되면 cnt 감소 (초밥 종류 감소)
				cnt--;
			
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
		
		
	}

}
