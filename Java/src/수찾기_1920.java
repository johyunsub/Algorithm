import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for(int i=0; i<n; i++) 
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] toFind = new int[m];
		for(int i=0; i<m; i++) 
			toFind[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++)
			sb.append(binarySearch(nums, toFind[i], 0, n-1)).append("\n");
		System.out.println(sb);
	}

	private static int binarySearch(int[] nums, int key, int start, int end) {
		if(start <= end) {
			int mid = (start + end)/2;
			if(nums[mid] == key)
				return 1;
			else if(nums[mid] > key)
				return binarySearch(nums, key, start, mid-1);
			else if(nums[mid] < key)
				return binarySearch(nums, key, mid+1, end);
		}
		return 0;	// 탐색 실패
	}
}
