
/*Problem statement-- Split a string in such a way that each words belongs to a dictionary
 * Reference-- http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
*/
import java.util.HashSet;


public class WordBreakPrint {
	
	public static void main(String[] args) {

		HashSet<String> vocabs = new HashSet<String>();
		vocabs.add("i");
		vocabs.add("love");
		vocabs.add("ice");
		vocabs.add("cream");
		vocabs.add("like");
		vocabs.add("icecream");

		HashSet<String> memory = new HashSet<String>();

		WordBreakPrint sp = new WordBreakPrint();

		String str = "ilikeice";

		sp.WordBreakUtil(str, vocabs, memory, "");
	}

	public boolean WordBreakUtil(String str, HashSet<String> vocabs, HashSet<String> memory, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return true;
		} 
		else if (memory.contains(str)) {
			return false;
		} 
		else {
			int index = 0;
			String s = "";

			while (index < str.length()) {
				s += str.charAt(index);

				if (vocabs.contains(s)) {
					if (WordBreakUtil(str.substring(index + 1), vocabs, memory, result + s + " ")) {
						return true;
					} 
					else {
						index++; // if we skip this else statement, s will not be added to the result and will be lost
					}
				}
				else {
						index++;
					}
				}
			}
			memory.add(str);
			return false;
		}

	}

