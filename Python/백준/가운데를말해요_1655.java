import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {	
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;	//내림차순
			}
		});
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i%2 == 0) maxHeap.offer(num);
			else minHeap.offer(num);
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				int tmp = maxHeap.poll();
				maxHeap.offer(minHeap.poll());
				minHeap.offer(tmp);
			}
			sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb);
	}
}
