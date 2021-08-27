import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나이순정렬_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Member> club = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			club.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		Collections.sort(club, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				return o1.age - o2.age;
			}
		});
		
		for(Member m : club)
			sb.append(m.age).append(" ").append(m.name).append("\n");
		System.out.println(sb);
	}
	static class Member {
		int age;
		String name;
		
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
}

