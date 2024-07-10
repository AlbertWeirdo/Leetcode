import java.util.ArrayList;
import java.util.HashSet;

public class q1823 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findTheWinner(5, 2);
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
        int count = 0;
        int currentLoc = 1;
        int ans;
        buildList(n);
        while (count < (n - 1)) {

        }

    }
}