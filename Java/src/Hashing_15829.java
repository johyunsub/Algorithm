import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing_15829 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] word = br.readLine().toCharArray();
		int sum = 0;
		for(int i=0; i<n; i++) 
			sum = (int) ((sum + (word[i]-96) * Math.pow(31, i)) % 1234567891);
				
		System.out.println(sum);
	}
}
