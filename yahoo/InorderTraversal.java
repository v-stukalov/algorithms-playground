package yahoo;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    List<Integer> output = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        if(root == null) return output;
        inorderTraversal(root.left);
        output.add(root.val);
        inorderTraversal(root.right);
        return output;
    }
}
