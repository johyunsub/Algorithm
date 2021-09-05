import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달_2839 {
	static int n, d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dfs(0, 0);
		if(d == 0)
			System.out.println(-1);
		else
			System.out.println(d);
	}
	private static boolean dfs(int depth, int sum) {
		if(n == sum) {
			d = depth;
			return true;
		}
		else if(n < sum)
			return false;
		if(dfs(depth+1, sum + 5))
			return true;
		if(dfs(depth+1, sum + 3))
			return true;
		return false;
	}
}
