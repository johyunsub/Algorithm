import java.util.Arrays;
import java.util.Scanner;

public class Food {
	static int N, totalcnt=0, len, min=99999;
	static boolean[] isSel;
	static int[][] flav; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		isSel = new boolean[N];			//뽑혔는지
		flav = new int[N][2] ;			//입력받은 재료
		len = (int) Math.pow(2, N)-1;	//재료조합의  경우의 수
		
		for(int t=0; t<N; t++) {
			for(int j=0; j<2; j++) {
				flav[t][j] = sc.nextInt();
			}
		}
		
		subset(0);
		System.out.println(min);	//가장작은 원소
	}	
	
	
	static void subset(int cnt) {
		
		if(cnt == N) {
			//마지막경우: 아무것도 안뽑았을 경우 return
			if(totalcnt == len) {
				return;
			}
			
			int tmp1=1, tmp2=0;
			for(int i=0; i<N; i++) {
				if(isSel[i]) {
					tmp1 *= flav[i][0];				
					tmp2 += flav[i][1];
				}
			}
			
			//절대값의 최대값 찾기
			if(min > Math.abs(tmp1-tmp2))
				min = Math.abs(tmp1-tmp2);
			totalcnt++;
			
			return;
		}
		
		isSel[cnt] = true;
		subset(cnt+1);
		isSel[cnt] = false;
		subset(cnt+1);
		
	}

}
