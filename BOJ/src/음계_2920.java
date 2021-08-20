import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음계_2920 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int flag = 0;
		if(a == 1) flag = 0;
		else if(a == 8) flag = 1;
		else{
			System.out.println("mixed");
			return;
		}
		while(st.hasMoreTokens()) {
			int b = Integer.parseInt(st.nextToken());
			if(flag == 0) {
				if(a+1 == b) {
					a = b;
				}else {
					flag = 2;
					break;
				}
			}else if(flag == 1) {
				if(a-1 == b) {
					a = b;
				}else {
					flag = 2;
					break;
				}
			}
		}
		if(flag == 0) System.out.println("ascending");
		else if(flag == 1) System.out.println("descending");
		else System.out.println("mixed");
	}
	
}


//1 2 3 4 5 6 7 8