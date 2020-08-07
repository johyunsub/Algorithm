import java.util.Arrays;
import java.util.Scanner;

public class Food {
	static int N, totalcnt=0, len;
	static boolean[] isSel;
	static int[] result;
	static int[][] flav; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		isSel = new boolean[N];			//뽑혔는지
		flav = new int[N][2] ;			//입력받은 재료
		len = (int) Math.pow(2, N)-1;	//재료조합의  경우의 수
		result = new int[len];			
		
		
		for(int t=0; t<N; t++) {
			for(int j=0; j<2; j++) {
				flav[t][j] = sc.nextInt();
			}
		}
		
		
		subset(0);
		
		Arrays.sort(result);	//오름차순으로 정렬
		System.out.println(result[0]);	//가장작은 원소
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
			result[totalcnt++]  = Math.abs(tmp1-tmp2);
			return;
		}
		
		isSel[cnt] = true;
		subset(cnt+1);
		isSel[cnt] = false;
		subset(cnt+1);
		
	}

}
