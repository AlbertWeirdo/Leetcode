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
        buildSet(n);
        while (set.size() > 1) {

        }

    }
}