class Solution {
    private int distanceFromMain = 0;

    public int minOperations(String[] logs) {
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                if (distanceFromMain > 0) {
                    distanceFromMain--;
                }
            } else if (logs[i].equals("./")) {
                continue;
            } else {
                distanceFromMain++;
            }
        }

        return distanceFromMain;
    }
}