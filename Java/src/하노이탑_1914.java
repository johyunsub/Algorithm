import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 하노이탑_1914 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(new BigInteger("2").pow(n).subtract(new BigInteger("1")));
		if(n <= 20) {
			hanoi(n, 1, 3, 2);
			System.out.println(sb);
		}
	}

	private static void hanoi(int n, int start, int end, int via) {
		if(n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		hanoi(n-1, start, via, end);
		sb.append(start).append(" ").append(end).append("\n");
		hanoi(n-1, via, end, start);
	}
}
