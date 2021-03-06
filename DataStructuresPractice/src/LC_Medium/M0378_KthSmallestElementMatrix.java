package LC_Medium;
/*
Read this = https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
https://www.youtube.com/watch?v=FOa55B9Ikfg
 */
public class M0378_KthSmallestElementMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int lo = matrix[0][0], hi = matrix[matrix.length-1][matrix[0].length-1] +1;
		while(lo<  hi){
			int mid = lo + (hi-lo)/2;
			int count = 0;
			int j = matrix[0].length-1;
			
			for(int i = 0; i< matrix.length; i++){
				while(j>= 0 && matrix[i][j] > mid) j--;
				count+= (j+1);
			}
			if(count<k) lo = mid+1;
			else hi = mid;
		}
		
		return lo;
	}
	public static void main(String[] args) {
		M0378_KthSmallestElementMatrix cl = new M0378_KthSmallestElementMatrix();
		int[][] array = {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(cl.kthSmallest(array,8));
	}
}
