import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer[]> stack = new Stack<Integer[]>();
		
		Integer[] a;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int h = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >= h) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				System.out.print(0 + " ");
			}
			
			a = new Integer[2];
			a[0] = i;
			a[1] = h;
			stack.push(a);
		}
		br.close();
	}
}
