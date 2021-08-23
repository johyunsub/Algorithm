import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직각삼각형_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			if((a|b|c) == 0) break;
			int tmp;
			if(a < b && b > c | a > c) {
				tmp = c;
				c = b;
				b = tmp;
			}
			else if(a > c | b > c) {
				tmp = a;
				a = c;
				c = tmp;
			}
			if(c*c == (a*a + b*b))
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
	
}
