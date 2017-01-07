/***
* Date 01/04/2017
* @author Tashnim Chowdhury
* References 
* http://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
*/

import java.util.Arrays;
public class SortingArrayAccordingToAnotherArray {

	public static void main(String[] args) {
		int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int[] A2 = {2, 1, 8, 3};
		
		
		
		int[] sortedArray = sortedArray(A1, A2);
		
		System.out.println(Arrays.toString(sortedArray));
		
		
	}
	
	public static int[] sortedArray(int[] A1, int[] A2) {
		int[] temp = new int[A1.length];
		int[] checkingArray = new int[A1.length];
		
		//System.out.println(Arrays.toString(A1));
		int index = 0;
		for (int i=0; i< A1.length; i++){
			temp[i] = A1[i];
			checkingArray[i] = 0;
		}
		
		
		Arrays.sort(temp);
		for (int j=0; j< A2.length; j++){
			
			int init = initPos(temp, A2[j], 0, A1.length-1); 
			if (init == -1){
				continue;
			}
			
			for (int k=init; (k<A1.length && temp[k]==A2[j]); k++){
				A1[index++] = temp[k];
				checkingArray[k] = 1;
			}
		}
		
		for (int i=0; i< A1.length; i++){
			if (checkingArray[i]==0){
				A1[index++] = temp[i];
				checkingArray[i] = 1;
			}
		}
		
		return A1;
	}
	
	// Binary search for first occurrence of a2 in array a1
	private static int initPos(int[] a1, int a2, int low, int high) {
		
		
		if (high>=low){
			int mid = (low+high)/2;
			
			if (a2==a1[mid]){
				return mid;
			}
			if (a2 > a1[mid]){
				return initPos(a1, a2, mid+1, high);
			}
			return initPos(a1, a2, low, mid-1);
		}
		return -1;
	}

}

