import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나머지_3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[42];
		int cnt = 0;
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine())%42;
			if(!check[n]) {
				check[n] = true;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
