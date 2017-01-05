/***
* Date 01/04/2017
* @author Tashnim Chowdhury
* References 
* http://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
*/


class nodeCreation {
	int data;
	nodeCreation left, right;
	
	public nodeCreation(int d){
		data = d;
		left = right = null;
	}

}



class ArrayToBST {
	static nodeCreation root;

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		
		ArrayToBST tree = new ArrayToBST();
		int len = arr.length;
		root = sortedArrayToBST(arr, 0, len-1);
		
		System.out.println("Resultant tree is printed as follows: ");
		tree.printInPreOrder(root);
		

	}
	
	static nodeCreation sortedArrayToBST(int[] array, int low, int high) {
		if(low > high){
			return null;
		}
		
		int mid = (low+high)/2;
		
		nodeCreation node = new nodeCreation(array[mid]);
		
		node.left = sortedArrayToBST(array, low, mid-1);
		node.right = sortedArrayToBST(array, mid+1, high);
		
		return node;
		
	}
	
	void printInPreOrder(nodeCreation node){
		if (node == null){
			return;
		}
		
		System.out.print(node.data+" ");
		
		printInPreOrder(node.left);
		printInPreOrder(node.right);
	}

}

