class Solution {
    public int passThePillow(int n, int time) {
        int totalLength = 2 * (n - 1);
        int loc = (time % totalLength) + 1;
        int ans = Math.min(loc, 2 * n - loc);
        return ans;
    }
}