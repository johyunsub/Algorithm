import java.util.Scanner;

public class 주사위쌓기_2116 {
	static int N, sum, ans;
	static int[][] dices;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		dices = new int[N][6];
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			for(int j=0, k=0; j<11; j+=2, k++) {
				dices[i][k] =  str.charAt(j)-'0';
			}
		}
		ans = 0;
		for(int i=0; i<6; i++) {	//1번 주사위 윗면 하나씩 set
			sum = 0;
			int btm = dices[0][findPairIdx(i)];	//밑면
			int top = dices[0][i];	//윗면
			int max = 0;
			for(int k=0; k<6; k++) {	//1번 주사위옆면 중 가장 큰 수
				if(k==top || k==btm)
					continue;
				if(max < dices[0][k])
					max = dices[0][k];
			}
			sum += max;
			
			for(int j=1; j<N; j++) {	//2번 주사위 ~
				max = 0;
				for(int k=0; k<6; k++) {	//주사위의 밑면 찾기
					if(dices[j][k]==dices[j][top]) {
						btm = top;
						top = findPairIdx(k);
						break;
					}
				}
				for(int l=0; l<6; l++) {
					if(l==top || l==btm) continue;
					if(max < dices[j][l])
						max = dices[j][l];
				}
				sum += max;
				
			}
			
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
	
	//주사위의 반대편 인덱스 찾는 함수
	static int findPairIdx(int idx) {	
		switch(idx) {
			case 0:
				return 5;
			case 1:
				return 3;
			case 2:
				return 4;
			case 3:
				return 1;
			case 4:
				return 2;
			case 5:
				return 0;
		}
		return -1;
	}
}
