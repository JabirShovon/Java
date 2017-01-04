import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
* Date 01/04/2017
* @author Tashnim Chowdhury
* References 
* https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/nice-arches-1/
*/
public class niceArches {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			
			boolean b = isBubbly(str);
			if (b) {
				count++;
			}
		}

		System.out.println(count);

	}

	public static boolean isBubbly(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				Character peek = stack.peek();
				if (peek != c) {
					stack.push(c);
				} else {
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}

}
