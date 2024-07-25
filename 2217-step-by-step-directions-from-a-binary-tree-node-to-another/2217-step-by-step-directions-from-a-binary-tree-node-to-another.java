class Solution {
    private StringBuilder start = new StringBuilder();
    private StringBuilder end = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {

        locateNode(root, startValue, start);
        locateNode(root, destValue, end);

        int i = 0;
        int max = Math.min(end.length(), start.length());
        while (i < max && start.charAt(start.length() - i - 1) == end.charAt(end.length() - i - 1)) {
            ++i;
        }
        return "U".repeat(start.length() - i) + end.reverse().toString().substring(i);
    }

    private boolean locateNode(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val) {
            return true;
        }
        if (root.right != null && locateNode(root.right, val, sb)) {
            sb.append('R');
        } else if (root.left != null && locateNode(root.left, val, sb)) {
            sb.append('L');
        }
        return (sb.length() > 0);
    }
}