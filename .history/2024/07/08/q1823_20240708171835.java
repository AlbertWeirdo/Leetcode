import java.util.ArrayList;
import java.util.HashSet;

public class q1823 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findTheWinner(1, 1);
    }
}

class Solution {
    private ArrayList<Integer> list = new ArrayList<>();

    public void buildList(int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1l
        }
        buildList(n);
        int count = 1;
        int currentLoc = (k - 1);
        list.remove(currentLoc);
        int ans = 0;
        while (count < (n - 1)) {
            currentLoc += (k - 1);
            while (currentLoc >= list.size()) {
                currentLoc -= list.size();
            }
            list.remove(currentLoc);
            count++;
        }
        ans = list.get(0);
        return ans;
    }
}