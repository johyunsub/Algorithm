import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합_11720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] nums = br.readLine().toCharArray();
		int sum = 0;
		for(char i: nums) sum += i;
		System.out.println(sum - 48*n);
	}
}
