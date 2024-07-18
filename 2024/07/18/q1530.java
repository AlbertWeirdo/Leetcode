// 1530. Number of Good Leaf Nodes Pairs
// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/

import java.util.ArrayList;
import java.util.List;

public class q1530 {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3, null, node2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node5, node3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1, node6, null);
        TreeNode root = new TreeNode(7, node1, node4);

        Solution s = new Solution();
        s.countPairs(root, 3);
        // StringBuilder sb = new StringBuilder();
        // s.storeLeavesPath(root, sb);

    }
}

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
