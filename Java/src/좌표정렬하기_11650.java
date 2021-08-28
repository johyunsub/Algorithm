import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 좌표정렬하기_11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> grp = new ArrayList<int[]>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] tmp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			grp.add(tmp);
		}
		
		Collections.sort(grp, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		
		for(int[] g : grp)
			System.out.println(g[0] + " " + g[1]);
	}
}
