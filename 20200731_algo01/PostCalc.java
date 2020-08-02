import java.util.Scanner;
import java.util.Stack;

public class PostCalc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for(int test_case=1; test_case<=10; test_case++ ) {
			Stack<Integer> num = new Stack<Integer>();
			Stack<Character> oper = new Stack<Character>();
			sc.nextInt();
			
			int num1, num2, num3, result = 0;
			
			String str = sc.next();
			char[] sta = str.toCharArray();
			
			for(char ch : sta) {
				if(ch >= '0' && ch <= '9'){
					num.push(new Integer(ch+""));
				}
				else if(oper.isEmpty()) {	//연산자스택 비어있을 경우
					oper.push(ch);
				}
				
				//스택: +, 읽음: + 인 경우
				//스택에 있는 가까운 두항을 더해놓음
				else if(!oper.isEmpty() && ch == '+' &&  oper.peek() == '+') {	
					oper.push(ch);
					num1 = num.pop();
					num2 = num.pop();
					num3 = num1 + num2;
					num.push(num3);
				}
				
				//스택: +, 읽음: *
				//다음 연산자가 *이므로 연산처리를 대기시킴(스택에 *넣음)
				else if(!oper.isEmpty() && ch == '*' && oper.peek() == '+') {	
					oper.push(ch);
				}
				
				//스택: *, 읽음: *
				//다음 연산자가 *이므로 스택에 있는 가까운 두항을 곱해놓음
				else if(!oper.isEmpty() && ch == '*' && oper.peek() == '*') {	
					num1 = num.pop();
					num2 = num.pop();
					num3 = num1 * num2;
					num.push(num3);
				}
				
				//스택: *, 읽음: +
				//다음 연산자가 +이므로 가까운 두항을 곱해놓음
				else if(!oper.isEmpty() && ch == '+' && oper.peek() == '*') {	
					num1 = num.pop();
					num2 = num.pop();
					num3 = num1 * num2;
					oper.pop();
					num.push(num3);
					oper.push(ch);
				}		
			}
			
			//마지막이 곱일 경우
			if(oper.peek() == '*') {
				num1 = num.pop();
				num2 = num.pop();
				num3 = num1 * num2;
				num.push(num3);
			}
			
			//곱셈처리가 다 된 모든 항들을 더해줌
			while(!num.isEmpty()) {
				result += num.pop();
			}
			
			System.out.println("#" + test_case + " " + result);
		}
		
	
	}
}
