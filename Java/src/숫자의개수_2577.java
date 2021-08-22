import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수_2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = 1;
		for(int i=0; i<3; i++) n *= Integer.parseInt(br.readLine());
		int[] nums = new int[10];
		for(int i=0; i<10; i++) {
			if(n == 0) break;
			nums[n%10]++;
			n /= 10;
		}
		for (int i=0; i<10; i++) sb.append(nums[i] + "\n");
		System.out.println(sb);
	}
}
