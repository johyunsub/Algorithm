import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈_8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			char[] str = br.readLine().toCharArray();
			int score = 1;
			int totScore = 0;
			for(int i=0; i<str.length; i++) {
				if(str[i] == 'O') {
					totScore += score++;
				}else {
					score = 1;
				}
			}
			sb.append(totScore + "\n");
		}
		System.out.println(sb);
	}
}
