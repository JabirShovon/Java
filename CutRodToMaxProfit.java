/**
 * Date 01/07/2017
 * @author Tashnim Chowdhury
 *
 * References -
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * Problem Statement-- Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 */



public class CutRodToMaxProfit {

	public static void main(String[] args) {
		int[] price = {1,5,8,9,10,17,17,20};
		int len = 8;
		int val = MaxVal(price, len);
		System.out.println(val);
		
	}

	public static int MaxVal(int[] price, int len) {
		int[][] array = new int[price.length+1][len+1];
		for (int i=0; i<=price.length; i++){
			for (int j=0; j<=len; j++){
				if (j==0 || i==0){
					array[i][j] = 0;
					continue;
				}
				if (j>=i){
					array[i][j] = Math.max(array[i-1][j], price[i-1]+array[i][j-i]);
				}
				else {
					array[i][j] = array[i-1][j];
				}
			}
		}
		System.out.println(array[price.length][len]);
		return array[price.length][len];
	}

	
}


