import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳찾기_10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] word = br.readLine().toCharArray();
		int[] alpha = new int[26];
		for(int i=0; i<26; i++) alpha[i] = -1;
		for(int i=0; i<word.length; i++) {
			if(alpha[word[i]-97] >= 0) continue; 
			alpha[word[i]-97] = i;
		}
		for(int i=0; i<26; i++) {
			sb.append(alpha[i]).append(' ');
		}
		System.out.println(sb);
	}
}
