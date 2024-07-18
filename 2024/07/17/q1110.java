// 1110. Delete Nodes And Return Forest
// https://leetcode.com/problems/delete-nodes-and-return-forest/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q1110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.left.left.left = new TreeNode(10);
        int[] to_delete = { 3, 4 };
        Solution s = new Solution();
        List<TreeNode> ans = s.delNodes(root, to_delete);
    }
}

class Solution {
    private List<TreeNode> ans = new ArrayList<>();
    private Set<Integer> toDeleteSet;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        root = reBuildTree(root);
        if (root != null) {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode reBuildTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = reBuildTree(root.left);
        root.right = reBuildTree(root.right);

        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            return null;
        }
        return root;
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