
/*
 * 
 * Rabin Karp Algorithm for substring matching
 * 
 * 
 * */


public class RabinKarpSubStringMatch {

	static int prime = 101;
	public static void main(String[] args) {
		RabinKarpSubStringMatch rks = new RabinKarpSubStringMatch();
        System.out.println(rks.patternMatch("TashnimChowdhury".toCharArray(), "shnim".toCharArray()));
        System.out.println(rks.patternMatch("TashnimChowdhury".toCharArray(), "Chw".toCharArray()));
        System.out.println(rks.patternMatch("TashnimChowdhury".toCharArray(), "nimC".toCharArray()));

	}
	
	public static int patternMatch(char[] text, char[] pattern) {
		int len_p = pattern.length;
		int len_t = text.length;
		
		long patternHash = hashFunction(pattern, 0, len_p-1);
		long textHash = hashFunction(text, 0, len_p-1);
		
		
		for (int i=1; i <= len_t-len_p+1; i++){
			if (textHash==patternHash && checkEqual(text, i-1, i+len_p-2, pattern, 0, len_p-1)){
				return i-1;
			}
			if (i < len_t-len_p+1){
				textHash = recalculateHash(text, i-1, i+len_p-1, textHash, len_p);
			}
		}
		return -1;
	}

	private static long recalculateHash(char[] str, int start, int end, long oldHash, int len) {
		long newHash = oldHash - str[start];
		newHash = newHash/prime;
		newHash += str[end]*Math.pow(prime, len-1);
		return newHash;
	}

	private static boolean checkEqual(char[] text, int start1, int end1, char[] pattern, int start2, int end2) {
		if (end1-start1 != end2-start2){
			return false;
		}
		for(int i=start1, j=start2; i<end1 && j< end2; i++, j++){
			if (text[i]!=pattern[j]){
				return false;
			}
		}
		return true;
	}

	private static long hashFunction(char[] str, int start, int end) {
		long hash = 0;
		for (int i=start; i<= end; i++){
			hash+= str[i]*Math.pow(prime, i);
		}
		
		return hash;
	}

}
