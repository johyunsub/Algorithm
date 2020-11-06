import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경비원_2564 {
	static int H, W, N, loc[], xv, xd;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());  //가로
		H = Integer.parseInt(st.nextToken());  //세로
		N = Integer.parseInt(br.readLine()) + 1;  //상점과 동근이의 수
		loc = new int[N];  //상점과 동근이의 위치를 저장할 배열
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());  
			int v = Integer.parseInt(st.nextToken());  //방향
			int d = Integer.parseInt(st.nextToken());  //위치
			switch(v) {  //북 - 동 - 남 - 서  순으로 일자로 펼친후 왼쪽 0부터 상점or동근이의 위치를 계산
			case 1: loc[i] = d;			break;  //북방향이면 상점or동근이의 위치를 계산 
			case 2: loc[i] = 2*W+H-d;	break;  //남방향이면 상점or동근이의 위치를 계산
			case 3: loc[i] = 2*W+2*H-d;	break;  //서방향이면 상점or동근이의 위치를 계산 
			case 4: loc[i] = W+d;		break;  //동방향이면 상점or동근이의 위치를 계산
			}
		}
		int x = loc[N-1];  //동근이의 위치
		int sum = 0, len = 2*W+2*H;  //상점까지의 거리의 최소값들의 합, 전체길이
		for(int i=0; i<N-1; i++)  //상점과 동근이 사이의 거리가 최소인지, 상점과 동근이의 바깥거리가 최소인지 계산
			sum += Math.min(Math.abs(x-loc[i]), (x > loc[i]) ? (len-x + loc[i]) : (len-loc[i] + x));  
		System.out.println(sum);
	}
}
