import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// This code is written according to the code written by Suresh Sajja in Github for Hackerearth. I have just written it just to understand
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
