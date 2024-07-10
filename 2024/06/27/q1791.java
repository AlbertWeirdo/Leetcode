class Solution {
    private int ans1 = 0;
    private int ans2 = 0;
    private int ans1Conut = 0;
    private int ans2Count = 0;

    public int findCenter(int[][] edges) {
        this.ans1 = edges[0][0];
        this.ans2 = edges[0][1];
        for (int i = 1; i < edges.length; i++) {
            containElement(edges[i]);
            if (ans1Conut > ans2Count) {
                return ans1;
            } else if (ans1Conut < ans2Count) {
                return ans2;
            }
        }
        return ans1;

    }

    private void containElement(int[] edges) {
        for (int i = 0; i < 2; i++) {
            if (edges[i] == ans1) {
                ans1Conut++;
            }
            if (edges[i] == ans2) {
                ans2Count++;
            }
        }
    }
}
