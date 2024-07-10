// 1550. Three Consecutive Odds
// https://leetcode.com/problems/three-consecutive-odds/description/?envType=daily-question&envId=2024-07-01

public class q1550 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1, 2, 34, 3, 4, 5, 7, 23, 12 };
        System.out.println(s.threeConsecutiveOdds(arr));
    }

}

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < (arr.length - 2); i++) {
            if ((arr[i] % 2 == 1) && (arr[i + 1] % 2 == 1) && (arr[i + 2] % 2 == 1)) {
                return true;
            }
        }
        return false;
    }
}