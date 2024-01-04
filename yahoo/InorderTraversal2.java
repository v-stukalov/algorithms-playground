package yahoo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal2 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> output = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node !=null && !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node = stack.pop();
            output.add(node.val);
            node = node.right;
        }
        return output;
    }
}
