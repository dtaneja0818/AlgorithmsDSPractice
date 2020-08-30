package LC_Medium;
/*
One observation is that, if A[0] works, no need to check B[0].
Because if both A[0] and B[0] exist in all dominoes,
when you swap A[0] in a whole row,
you will swap B[0] in a whole at the same time.
The result of trying A[0] and B[0] will be the same.


Solution 1:
Count the occurrence of all numbers in A and B,
and also the number of domino with two same numbers.

Try all possibilities from 1 to 6.
If we can make number i in a whole row,
it should satisfy that countA[i] + countB[i] - same[i] = n

Take example of
A = [2,1,2,4,2,2]
B = [5,2,6,2,3,2]

countA[2] = 4, as A[0] = A[2] = A[4] = A[5] = 2
countB[2] = 3, as B[1] = B[3] = B[5] = 2
same[2] = 1, as A[5] = B[5] = 2

We have countA[2] + countB[2] - same[2] = 6,
so we can make 2 in a whole row.

Time O(N), Space O(1)
 */

public class M1007_MinimumDominoRotationForEqualRow {
	public int minDominoRotations(int[] A, int[] B) {
		int[] countA = new int[7], countB = new int[7], same = new int[7];
		int n = A.length;
		for (int i = 0; i < n; i++) {
			countA[A[i]]++;
			countB[B[i]]++;
			if (A[i] == B[i])
				same[A[i]]++;
		}
		
		for (int i  = 1; i < 7; i++){
			if (countA[i] + countB[i] - same[i] == n) // check if any value combining defines the length of total array
				// because we need to make one array with same elements
				return n-Math.max(countA[i],countB[i]);  //if yes then take the max and remaining rotations are required
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {2,1,2,4,2,2};
		int[] B = {5,2,6,2,3,2};
		M1007_MinimumDominoRotationForEqualRow cl = new M1007_MinimumDominoRotationForEqualRow();
		System.out.println(cl.minDominoRotations(A,B));
	}
}
