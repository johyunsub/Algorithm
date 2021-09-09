import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		quickSort(arr, 0, n-1);
		for(int item : arr)
			sb.append(item).append("\n");
		System.out.println(sb);
	}

	private static void quickSort(int[] arr, int start, int end) {
		int part2 = patition(arr, start, end);
		if(start < part2 -1) 
			quickSort(arr, start, part2 -1);
		if(part2 < end)
			quickSort(arr, part2, end);
	}

	private static int patition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) /2];
		while(start <= end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			if(start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	
}
