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

class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childrenSet = new HashSet<>();
        Map<Integer, int[]> childrenHashMap = new HashMap<>();

        for (int[] des : descriptions) {
            int parent = des[0];
            int child = des[1];
            boolean left = (des[2] == 1);

            childrenHashMap.putIfAbsent(parent, new int[] { -1, -1 });
            childrenSet.add(child);

            if (left) {
                childrenHashMap.get(parent)[0] = child;
            } else {
                childrenHashMap.get(parent)[1] = child;
            }
        }
        int root = 0;
        for (int i : childrenHashMap.keySet()) {
            if (!childrenSet.contains(i)) {
                root = i;
                break;
            }
        }
        return constructTree(root, childrenHashMap);
    }

    private TreeNode constructTree(int root, Map<Integer, int[]> childrenHashmap) {
        TreeNode newNode = new TreeNode(root);
        if (childrenHashmap.containsKey(root)) {
            int[] children = childrenHashmap.get(root);
            if (children[0] != -1) {
                newNode.left = constructTree(children[0], childrenHashmap);
            }
            if (children[1] != -1) {
                newNode.right = constructTree(children[1], childrenHashmap);
            }
        }
        return newNode;
    }
}