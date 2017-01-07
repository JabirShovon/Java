

/**
 * Date 01/07/2017
 * @author Tashnim Chowdhury
 *
 * References -
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * 
 */
public class KnapsackBottomUpDP {

	public static void main(String[] args) {
		int[] weight = {1,3,4,5};
		int[] value = {1,4,5,7};
		int maxW = 7;
		int result = BottomUpDP(weight, value, maxW);
		System.out.println(result);
	}
	
	public static int BottomUpDP(int[] weight, int[] value, int maxW){
		int array[][] = new int[weight.length+1][maxW+1];
		
		for (int i=0; i<=weight.length; i++){
			for (int j=0; j<=maxW; j++){
				if (i==0 || j==0){
					array[i][j]=0;
					continue;
				}
				if (j>=weight[i-1]){
					array[i][j]=Math.max(value[i-1] + array[i-1][j-weight[i-1]], array[i-1][j]);
				}
				else {
					array[i][j]=array[i-1][j];
				}
				
			}
		}
		return array[weight.length][maxW];
	}

}
