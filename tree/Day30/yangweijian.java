import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day30 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> createList(TreeNode root, List<Integer> list, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            list.add(Integer.parseInt(sb.toString()));
            if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
            return list;
        }
        if (root.left != null) list =  createList(root.left, list, sb.append(root.left.val));
        if (root.right != null) list = createList(root.right, list, sb.append(root.right.val));
        if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
        return list;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = createList(root, new ArrayList<>(), new StringBuilder(String.valueOf(root.val)));
        int sum = 0;
        for (int data: list) sum += data;
        return sum;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        List<Integer> list = createList(t1, new ArrayList<>(), new StringBuilder(String.valueOf(t1.val)));
        System.out.println(list);
    }
}
