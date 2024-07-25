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
