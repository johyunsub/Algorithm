import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알람시계_2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if(m < 45)
			if(h == 0) System.out.println(23 + " " + (m+15));
			else System.out.println(--h + " " + (m+15));
		else
			System.out.println(h + " " + (m-45));
	}
}
