package yahoo;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> output = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return output;

        output.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return output;
    }
}
