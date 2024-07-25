class Solution {
    private int emptyBottles = 0;
    private int ans = 0;

    public int numWaterBottles(int numBottles, int numExchange) {
        ans += numBottles;
        emptyBottles = numBottles;
        while (emptyBottles >= numExchange) {
            numBottles = emptyBottles / numExchange;
            emptyBottles = (emptyBottles % numExchange) + numBottles;
            ans += numBottles;
        }
        return ans;
    }
}