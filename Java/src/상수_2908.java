import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상수_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		boolean flag = false;
		for(int i=2; i>-1; i--)
			if(a[i] > b[i])
				break;
			else if(a[i] == b[i])
				continue;
			else {
				flag = true;
				break;
			}
		if(flag)
			for(int i=2; i>-1; i--)
				System.out.print(b[i]);
		else
			for(int i=2; i>-1; i--)
				System.out.print(a[i]);
	}
}
