import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 팰린드롬수_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(!str.equals("0")) {
			char[] chr = str.toCharArray();
			int len = chr.length;
			isPalin(chr, len);
			str = br.readLine();
		}
		
		
	}
	static void isPalin(char[] chr, int len) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<len/2; i++) {
			stack.add(chr[i]);
		}
		for(int i=(len+1)/2; i<len; i++) {
			if(stack.pop() != chr[i]) {
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
		return;
	}
}
