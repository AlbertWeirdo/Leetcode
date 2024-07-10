// 1382. Balance a Binary Search Tree
// https://leetcode.com/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2024-06-26

import java.util.Collections;
import java.util.HashSet;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private HashSet<Integer> sortedArray = new HashSet<>();

    public TreeNode balanceBST(TreeNode root) {
        if (root != null) {
            sortedArray.add(root.val);
        }
        sortArray();
        TreeNode balancedRoot = buildTree();
        return balancedRoot;

    }

    public void sortArray() {
        Collections.sort(sortedArray);
    }

    public TreeNode buildTree() {
        Integer[] sortedIntArray=sortedArray.toArray(new Integer[sortedArray.size()]);
        int rootLoc = sortedArray.size() / 2;
        int i = 1;
        int rootval= sortedArray.
        TreeNode root = new TreeNode(sortedIntArray[rootLoc]);
        while()
    }

}
