// 995. Minimum Number of K Consecutive Bit Flips
//https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/?envType=daily-question&envId=2024-06-24

import java.util.Arrays;

public class q995 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 1, 0 };
        int k = 2;
        s.minKBitFlips(nums, k);
    }
}

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int count = nums.length - (k - 1);
        int output = 0;
        int loc = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) {
                if (i == count - 1) {
                    for (int j = 0; j < k; j++) {
                        if (nums[i + j] == 1) {
                            return -1;
                        }
                    }
                }
                for (int j = 0; j < k; j++) {
                    if (nums[i + j] == 0) {
                        nums[i + j] = 1;
                    } else {
                        nums[i + j] = 0;
                    }
                }
                output++;
                loc = i;
            }
        }
        for (int i = loc; i < nums.length; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }
        return output;
    }
}
