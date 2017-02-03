
/*
 * Problem Statement-- Longest Increasing Subsequence
 * Time Complexity - O(n^2)
*/

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = { 3, 4, -1, 0, 6, 2, 3 };
		int[] arr2 = new int[arr.length];
		int[] arr3 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr2[i] = 1;
		}
		for (int i = 0; i < arr.length; i++) {
			arr3[i] = -1;
		}
		longestIncreasingSubsequence(arr, arr2, arr3);

	}

	public static void longestIncreasingSubsequence(int[] arr, int[] arr2, int[] arr3) {
		// Finding the longest increasing array
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && arr2[j] + 1 > arr2[i]) {
					arr2[i] = arr2[j] + 1;
					arr3[i] = j;
				}
			}
		}

		// Getting max length and its index
		int max_length = 0;
		int max_index = -1;
		for (int k = 1; k < arr2.length; k++) {
			if (arr2[k] > arr2[k - 1]) {
				max_length = arr2[k];
				max_index = k;
			} else {
				max_length = arr2[k - 1];
				max_index = k - 1;
			}
		}

		// Creating the resultant array
		int[] resultArr = new int[max_length];
		int index = max_index;
		for (int i = max_length - 1; i >= 0; i--) {
			resultArr[i] = arr[index];
			index = arr3[index];

		}

		// Printing the resultant array
		for (int i = 0; i < resultArr.length; i++) {
			System.out.println(resultArr[i]);
		}
	}

}
