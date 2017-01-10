
/**
 * Date 01/10/2017
 * References -
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {
	
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
        sp.permute("AABC".toCharArray()).forEach(s -> System.out.println(s));
	}

	public List<String> permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        StringPermute(str, count, result, 0, resultList);
        return resultList;
    }
	

	public void StringPermute(char[] str, int[] counter, char[] result, int level, List<String> resultList) {
		if (level == result.length){
			resultList.add(new String(result));
			return;
		}
		
		
		for (int i=0; i < str.length; i++){
			if (counter[i]==0){
				continue;
			}
			result[i] = str[i];
			counter[i]--;
			StringPermute(str, counter, result, level+1, resultList);
			counter[i]++;
		}
	}

	
}
