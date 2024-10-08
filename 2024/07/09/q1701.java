// 1701. Average Waiting Time
// https://leetcode.com/problems/average-waiting-time/description/

public class q1701 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] customers = { { 2, 3 }, { 6, 3 }, { 7, 5 }, { 11, 3 }, { 15, 2 }, { 18, 1 } };
        System.out.println(s.averageWaitingTime(customers));
    }
}

class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int currentTime = 0;
        for (int i = 0; i < customers.length; i++) {
            if (currentTime < customers[i][0]) {
                currentTime = customers[i][0];
            }
            currentTime += customers[i][1];
            totalWaitingTime += (currentTime - customers[i][0]);
        }
        double ans = totalWaitingTime / (double) customers.length;
        return ans;
    }
}