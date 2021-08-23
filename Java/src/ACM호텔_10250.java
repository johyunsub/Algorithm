import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM호텔_10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
			if(n%h != 0)
				System.out.println(n%h + "" + String.format("%02d", n/h+1));
			else
				System.out.println(h + "" + String.format("%02d", n/h));
		}
	}
}
