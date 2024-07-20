// 1605. Find Valid Matrix Given Row and Column Sums
// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/

public class q1605 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] rowSum = { 5, 7, 10 };
        int[] colSum = { 8, 6, 8 };
        int[][] ans = s.restoreMatrix(rowSum, colSum);
    }

}

class Solution {
    private int[][] ans;

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        ans = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}

// better solution
/*
 * class Solution {
 * public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
 * int row = rowSum.length;
 * int col = colSum.length;
 * int[][] ans = new int[row][col];
 * int i = 0, j = 0;
 * 
 * while (i < row && j < col) {
 * int minValue = Math.min(rowSum[i], colSum[j]);
 * ans[i][j] = minValue;
 * rowSum[i] -= minValue;
 * colSum[j] -= minValue;
 * 
 * if (rowSum[i] == 0) {
 * i++;
 * }
 * if (colSum[j] == 0) {
 * j++;
 * }
 * }
 * 
 * return ans;
 * }
 * }
 */
