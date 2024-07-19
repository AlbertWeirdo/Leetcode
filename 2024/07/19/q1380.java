// 1380. Lucky Numbers in a Matrix
// https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private Set<Integer> set = new HashSet<>();
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> luckyNumbers(int[][] matrix) {

        // find minimum element in each row
        for (int i = 0; i < matrix.length; i++) {
            int minimum = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < minimum) {
                    minimum = matrix[i][j];
                }
            }
            set.add(minimum);
        }
        // find maximum element in each column
        for (int i = 0; i < matrix[0].length; i++) {
            int maximum = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] > maximum) {
                    maximum = matrix[j][i];
                }
            }
            if (set.contains(maximum)) {
                ans.add(maximum);
            }
        }
        return ans;
    }
}