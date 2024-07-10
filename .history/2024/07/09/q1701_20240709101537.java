// 1701. Average Waiting Time
// https://leetcode.com/problems/average-waiting-time/description/

public class q1701 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] customers = { { 5, 2 }, { 5, 4 }, { 10, 3 }, { 20, 1 } };
        System.out.println(s.averageWaitingTime(customers));
    }
}

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int totalWaitingTime = 0;
        int currentTime = customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            currentTime += customers[i][1];
            if (currentTime < customers[i][0]) {
                totalWaitingTime += customers[i][1];
            } else {
                totalWaitingTime += (currentTime - customers[i][0]);
            }
        }
        double ans = (double) totalWaitingTime / customers.length;
        return ans;
    }
}