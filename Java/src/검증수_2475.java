import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 검증수_2475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = 0;
		while(st.hasMoreTokens()) n += Math.pow(Integer.parseInt(st.nextToken()), 2);
		System.out.println(n%10);
	}
}
