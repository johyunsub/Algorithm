import java.util.Scanner;

public class Z_1074 {
	static int count;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		divide(N, r, c);
		System.out.println(count);
	}
	private static void divide(int n, int r, int c) {
		if(n == 0) return;	//기저조건	(0,0)에서 반환
		
		int len = (int) Math.pow(2, n);	//행렬의 길이
		int size = len * len;	//행렬의 총 크기
		int partlen = len/2;	//행렬의 길이의 절반
		
		if(r < partlen &&  c < partlen) {	//1사분면일 경우
			divide(n-1, r, c);	//4분의1 크기의 행렬로 재귀
		}else if(r < partlen && c >= partlen) {	//2사분면일 경우
			count += size/4;	//1사분면 만큼의 크기를 더해줌
			divide(n-1, r, c-partlen);	//1사분면으로 재귀
		}else if(r >= partlen && c < partlen) {	//3사분면일 경우
			count += size/4 * 2;	//2사분면 만큼의 크기를 더해줌
			divide(n-1, r-partlen, c);	//1사분면으로 재귀
		}else if(r >= partlen && c >= partlen) {//4사분면일 경우
			count += size/4 *3;		//3사분면 만큼의 크기를 더해줌	
			divide(n-1, r-partlen, c-partlen);	//1사분면으로 재귀
		}
	}
}
