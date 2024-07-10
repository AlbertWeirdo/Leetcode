// 1701. Average Waiting Time
// https://leetcode.com/problems/average-waiting-time/description/

public class q1701 {

}

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int totalWaitingTime = 0;
        int currentTime = customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            currentTime += customers[i][1];
            totalWaitingTime += (currentTime - customers[i][0]);
        }
        double ans = (double) totalWaitingTime / customers.length;
        return ans;
    }
}