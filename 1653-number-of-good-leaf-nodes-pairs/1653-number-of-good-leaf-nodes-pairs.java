class Solution {
    private List<String> list = new ArrayList<>();
    private int ans = 0;

    public int countPairs(TreeNode root, int distance) {

        StringBuilder s = new StringBuilder();
        storeLeavesPath(root, s);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (compareStrings(list.get(i), list.get(j), distance)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void storeLeavesPath(TreeNode root, StringBuilder previous) {
        if (root.left == null && root.right == null) {
            list.add(previous.toString());
            // previous.deleteCharAt(previous.length() - 1);
        }

        if (root.left != null) {
            previous.append("L");
            storeLeavesPath(root.left, previous);
            previous.deleteCharAt(previous.length() - 1);
        }
        if (root.right != null) {
            previous.append("R");
            storeLeavesPath(root.right, previous);
            previous.deleteCharAt(previous.length() - 1);
        }

    }

    private boolean compareStrings(String str1, String str2, int distance) {
        int minimunLength = Math.min(str1.length(), str2.length());
        int count = 0;
        while (str1.charAt(count) == str2.charAt(count) && count < minimunLength) {
            count++;
        }
        if (((str1.length() + str2.length()) - count * 2) <= distance) {
            return true;
        }
        return false;
    }

}