import java.util.*;

public class BST {
    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    private static boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean validate(Node root, Integer lo, Integer hi) {
        if (root == null) return true;
        if (lo != null && root.val <= lo
                || hi != null && root.val >= hi) {
            return false;
        }
        return validate(root.left, lo, root.val)
                && validate(root.right, root.val, hi);
    }

    public static boolean isValid(Node root) {
        return validate(root, null, null);
    }

    public static int maxDepth(Node root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static boolean hasPathSum(Node root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum)
                || hasPathSum(root.right, sum);
    }

    public static void insert(Node root, int val) {
        if (root == null) root = new Node(val);
        if (val <= root.val) {
            if (root.left == null) {
                root.left = new Node(val);
            } else {
                insert(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(val);
            } else {
                insert(root.right, val);
            }
        }
    }

    private static Node min(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return min(root.left);
        }
    }

    public static Node delete(Node root, int val) {
        if (root == null) return null;
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if (root.left != null && root.right != null) {
                Node node = min(root.right);
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

    public static List<Integer> inOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Node node = root;
        Stack<Node> stack = new Stack<>();
        while (node != null && !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    public static List<Integer> preOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void printInOrder(Node root) {
        if (root == null) return;
        if (root.left != null) {
            printInOrder(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            printInOrder(root.right);
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
