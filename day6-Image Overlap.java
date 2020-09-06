Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1
Java	
1
class Solution {
2
    public int largestOverlap(int[][] A, int[][] B) {
3
        int largestOverlap = 0;
4
        for (int row = -A.length + 1; row < A.length; row++)
5
            for (int col = -A[0].length + 1; col < A[0].length; col++)
6
                largestOverlap = Math.max(largestOverlap, overlappingOnes(A, B, row, col));
7
        return largestOverlap;
8
    }
9
​
10
    public int overlappingOnes(int[][] A, int[][] B, int rowOffset, int colOffset) {
11
        int overlapOnes = 0;
12
        for (int row = 0; row < A.length; row++) {
13
            for (int col = 0; col < A[0].length; col++) {
14
                if ((row + rowOffset < 0 || row + rowOffset >= A.length) || (col + colOffset < 0 || col + colOffset >= A.length) || (A[row][col] + B[row + rowOffset][col + colOffset] != 2))
15
                    continue;
16
                overlapOnes++;
17
            }
18
        }
19
        return overlapOnes;
20
    }
21
}
