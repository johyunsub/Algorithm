import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n; i++)	q.offer(i);
		boolean flag = false;
		while(q.size() > 1)
			if(flag) {
				q.offer(q.poll());
				flag = false;
			}
			else {
				flag = true;
				q.poll();
			}
		
		System.out.println(q.peek());
	}
}
