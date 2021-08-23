import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			int sum = i;
			int a = i;
			for(int j=1; j<(int)Math.log10(i) + 2; j++) {
				sum += a%10;
				a /= 10;
			}
			if(sum == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
