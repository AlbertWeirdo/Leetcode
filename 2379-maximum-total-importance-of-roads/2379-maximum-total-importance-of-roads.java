class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public long maximumImportance(int n, int[][] roads) {

        for (int i = 0; i < roads.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (map.containsKey(roads[i][j])) {
                    map.replace(roads[i][j], map.get(roads[i][j]) + 1);
                } else {
                    map.put(roads[i][j], 1);
                }
            }
        }

        long ans = 0;
        Integer[] values = map.values().toArray(new Integer[0]);
        Arrays.sort(values);

        for (int i = 0; i < values.length; i++) {
            ans += (long) n * values[values.length - i - 1];
            n--;
        }
        return ans;
    }
}