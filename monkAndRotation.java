
import java.io.IOException;
import java.util.Scanner;

/***
* Date 01/04/2017
* @author Tashnim Chowdhury
* References 
* https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/monk-and-rotation-3/
*/


public class monkAndRotation {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int size;
		int rotation;
		int input;

		//System.out.println("Please enter the total number of input \n");
		input = in.nextInt();

		

		for (int z = 0; z < input; z++) {
			
			//System.out.println("Please enter the size and no of rotation\n");
			
			int[] inputArray2 = new int[2];
			for (int i = 0; i <= 1; i++) {
				inputArray2[i] = in.nextInt();
			}

			size = inputArray2[0];
			rotation = inputArray2[1];
			
			int[] array = new int[size];
			
			//System.out.println("Please enter the numbers now\n");
			for (int i = 0; i < array.length; i++) {
				array[i] = in.nextInt();
			}

			int[] newArray = rotation(array, rotation, size);
			/*for (int i = 0; i < newArray.length; i++) {
				System.out.println(newArray[i] + " ");
			}*/
			
			for (int i = 0; i < newArray.length; i++)
				sb.append(newArray[i] + " ");
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	public static int[] rotation(int[] array, int rotation, int size) {
		int j = 1;
		int[] arra = array;
		while (j <= rotation) {
			arra = changePosition(arra);
			j++;
		}
		return arra;
	}

	public static int[] changePosition(int[] ar) {
		int temp = ar[ar.length - 1];
		for (int i = ar.length - 2; i >= 0; i--) {
			ar[i + 1] = ar[i];
		}
		ar[0] = temp;

		return ar;
	}

}

