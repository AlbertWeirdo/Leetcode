class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] leftLess = new int[n];
        int[] leftGreater = new int[n];
        int[] rightLess = new int[n];
        int[] rightGreater = new int[n];

        // 計算左邊較小和較大的數量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftLess[i]++;
                } else if (rating[j] > rating[i]) {
                    leftGreater[i]++;
                }
            }
        }

        // 計算右邊較小和較大的數量
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    rightLess[i]++;
                } else if (rating[j] > rating[i]) {
                    rightGreater[i]++;
                }
            }
        }

        int ans = 0;
        // 計算上升和下降的隊伍數量
        for (int i = 0; i < n; i++) {
            ans += leftLess[i] * rightGreater[i] + leftGreater[i] * rightLess[i];
        }

        return ans;
    }
}
