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
        double ans =  totalWaitingTime / (double) customers.length;
        return ans;
    }
}