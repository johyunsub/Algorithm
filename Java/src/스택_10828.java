import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int stackSize = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				stackSize++;
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stackSize == 0)
					sb.append(-1).append("\n");
				else {
					stackSize--;
					sb.append(stack.pop()).append("\n");
				}
				break;
			case "size":
				sb.append(stackSize).append("\n");
				break;
			case "empty":
				if(stackSize == 0)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "top":
				if(stackSize == 0)
					sb.append(-1).append("\n");
				else
					sb.append(stack.peek()).append("\n");
				break;
			}
		}
		System.out.println(sb);
		
	}	
}
