import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key))
				map.replace(key, map.get(key)+1);
			else
				map.put(key, 1);
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key))
				sb.append(map.get(key)).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}
}
