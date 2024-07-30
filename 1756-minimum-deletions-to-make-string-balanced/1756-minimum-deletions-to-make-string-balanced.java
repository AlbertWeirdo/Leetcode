class Solution {
    public int minimumDeletions(String s) {
        int count_b = 0;
        int min_deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {

                min_deletions = Math.min(min_deletions + 1, count_b);
            } else {

                count_b++;
            }
        }

        return min_deletions;
    }
}
