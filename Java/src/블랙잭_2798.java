import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭_2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[] cards = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			cards[i] = Integer.parseInt(st.nextToken());
		int[] nums = new int[3];
		int near = 0;
		for(int i=0; i<n; i++) {
			nums[0] = cards[i];
			for(int j=i+1; j<n; j++) {
				nums[1] = cards[j];
				for(int k=j+1; k<n; k++) {
					int sum = nums[0] + nums[1] + cards[k];
					if(sum <= m && sum > near) near = sum;
				}
			}
		}
		System.out.println(near);
	}
}
