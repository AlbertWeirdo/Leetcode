// 1605. Find Valid Matrix Given Row and Column Sums
// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/

public class q1605 {
    Solution s = new Solution();
    int[] rowSum = { 3, 8 };
    int[] colSum = { 4, 7 };
    int[][] ans = s.restoreMatrix(rowSum, colSum);
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
