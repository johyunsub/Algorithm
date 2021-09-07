import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing_15829 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] word = br.readLine().toCharArray();
		long sum = 0;
		for(int i=0; i<n; i++) 
			sum = (long) ((sum + (word[i]-96) * pow(1, 0, i)) % 1234567891);
				
		System.out.println(sum);
	}
	static long pow(long a, int b, int r) {
		if(b == r)
			return a;
		a = pow(a*31 % 1234567891, ++b, r);
		return a;
	}
}
