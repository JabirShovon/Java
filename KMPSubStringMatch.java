
/**
 * @author Tashnim Chowdhury
 *
 * References -
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * 
 * 
 * Problem Statement-- SubString pattern matching using KMP algorithm
 */

public class KMPSubStringMatch {
	
	public static int[] PatternSuffixPrefix (String[] pattern){
		int[] SufPrefArr = new int[pattern.length];
		SufPrefArr[0]=0;
		
		int j=0;
		int i=1;
		
		while (j < i && i< pattern.length){
			if (pattern[i]==pattern[j]){
				SufPrefArr[i] = j+1;
				i++;
				j++;
			}
			else if (pattern[i]!=pattern[j] && (j-1)<=0){
				SufPrefArr[i]=0;
				j=0;
				i++;
			}
			else if(pattern[i]!=pattern[j] && (j-1)!=0) {
				j=SufPrefArr[j-1];
			}
		}
		return SufPrefArr;
	}
	
	public int KMPPatternMatching(String[] pattern, String[] text){
		int[] SufPrefArr = PatternSuffixPrefix(pattern);
		int i=0;
		int j=0;
		int finalIndex = 5;
		while (j<pattern.length && i<text.length){
			if (text[i]==pattern[j] && j!=pattern.length-1){
				i++;
				j++;
			}
			else if(text[i]==pattern[j] && j==pattern.length-1){
				finalIndex = i - pattern.length+1;
				return finalIndex;
			}
			else if(text[i]!=pattern[j] && (j-1)>0){
				j=SufPrefArr[j-1];
			}
			else if(text[i]!=pattern[j] && (j-1)<=0){
				i++;
			}
		}
		return finalIndex;
		
	}
	

	public static void main(String[] args) {
		KMPSubStringMatch s = new KMPSubStringMatch();
		String[] pattern = {"a","b","c","a","b","y"};
		String[] text = {"a","b","x","a","b","c","a","b","c","a","b","y"};
		
		int index = s.KMPPatternMatching(pattern, text);
		
		System.out.println(index);
		
	}

}
