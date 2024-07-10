// 1518. Water Bottles
// https://leetcode.com/problems/water-bottles/description/

public class q2582 {
    public static void main(String[] args) {

    }
}

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