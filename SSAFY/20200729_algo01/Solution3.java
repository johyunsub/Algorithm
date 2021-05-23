import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] matrix = new int[N][N];	//전체 필드
			int[][] pari = new int[M][M];	//파리채 크기
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			//파리채의 크기에 따른 필드에 차지되는 w크기만큼의 배열을 생성
			//ex) 5*5필드의 3*3파리채라면 w는 3으로써 res[3][3] 결과값을 가지는 배열생성
			int w = N - M +1;	
			int[][] res = new int[w][w];
			int sum;
			//w크기를 가지는 res배열
			for(int i=0; i<w; i++) {
				for(int j=0; j<w; j++) {
					//i,j인덱스에 따른  필드원소의 합을 res배열에 넣기
					sum=0;
					for(int k=i; k<i+M; k++) {
						for(int l=j; l<j+M; l++) {
							sum += matrix[k][l];
						}						
					}
					res[i][j] = sum;
				}
			}
			//res에서 max찾기
			int max = 0;
			for(int i=0; i<w; i++) {
				for(int j=0; j<w; j++) {
					if(res[i][j] > max) {
						max = res[i][j];
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}

}
