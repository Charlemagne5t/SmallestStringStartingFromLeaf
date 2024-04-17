public class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return preorder(root, "");
    }

    String preorder(TreeNode root, String cur) {
        if (root.left == null && root.right == null) {
            cur = cur + (char) ('a' + root.val);
            return new StringBuilder(cur).reverse().toString();
        }
        cur = cur + (char) ('a' + root.val);
        String left = root.left == null ? null : preorder(root.left, cur);
        String right = root.right == null ? null : preorder(root.right, cur);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.compareTo(right) < 0) {
            return left;
        } else {
            return right;
        }
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

