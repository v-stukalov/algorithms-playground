package yahoo;

public class InsertNode {
    public void insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        if (val <= root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insert(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insert(root.right, val);
            }
        }
    }
}
