package yahoo;

public class DeleteNode {
    public TreeNode delete(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if (root.left != null && root.right != null) {
                TreeNode node = min(root.right);
                root.val = node.val;
                root.right = delete(root.right, node.val);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    private TreeNode min(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
