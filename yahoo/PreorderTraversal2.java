package yahoo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal2 {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> output = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.add(node.val);
            if(node.left !=null)
                stack.add(node.left);
            if(node.right != null)
                stack.add(node.right);
        }
        return output;
    }
}
