// 1701. Average Waiting Time
// https://leetcode.com/problems/average-waiting-time/description/

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int total = 0;
        int currentTime = customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            currentTime += customers[i][1];
            total += (currentTime - customers[i][0]);
        }
        double ans = (double) total / customers.length;
        return ans;
    }
}