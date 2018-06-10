import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day21 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                result.push(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!result.isEmpty()) list.add(result.pop());
        return list;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2; t1.right = t3;
        t2.right = t4;
        t3.left = t5; t3.right = t6;

        System.out.println(postorderTraversal(t1));
    }
}
