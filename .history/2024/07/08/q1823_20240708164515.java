import java.util.HashSet;

public class q1823 {
    public static void main(String[] args) {

    }
}

class Solution {
    private HashSet<Integer> set = new HashSet<>();

    public void buildSet(int n) {
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
    }

    public int findTheWinner(int n, int k) {
        int count = 0;
        int currentLoc = 1;
        buildSet(n);
        while (count < (n - 1)) {
            currentLoc += k;
            set.remove(currentLoc);
            currentLoc += 1;
            if (currentLoc > n) {
                currentLoc -= n;
            }
            count++;
        }
        int ans = 0;
        for (int i : set) {
            ans = i;
        }
        return ans;
    }
}