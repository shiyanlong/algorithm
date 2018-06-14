package study.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Day23 {

    private String connect(Stack<String> operator) {
        List<String> list = new ArrayList<>();
        while (!operator.isEmpty()){
            String temp = operator.pop();
            if (temp.equals("[")) break;
            list.add(temp);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i --) sb.append(list.get(i));
        return sb.toString();
    }

    public String decodeString(String s) {
        if (s.equals("")) return "";
        Stack<Integer> number = new Stack<>();
        Stack<String> operator = new Stack<>();
        StringBuilder num = new StringBuilder();

        for (char c: s.toCharArray()) {
            if ('0' <= c && c <= '9') num.append(String.valueOf(c));
            else if (c == ']') {
                String str = connect(operator);
                StringBuilder tempS = new StringBuilder();
                int len = number.pop();
                for (int i = 0; i < len; i ++) tempS.append(str);
                operator.push(tempS.toString());
            } else {
                operator.push(String.valueOf(c));
                if (num.length() != 0) {
                    number.push(Integer.parseInt(num.toString()));
                    num.setLength(0);
                }
            }
        }
        String[] strings = operator.toArray(new String[]{});
        StringBuilder sb = new StringBuilder();
        for (String str: strings) sb.append(str);
        return sb.toString();
    }


// ========================邪恶分割线======================================


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int getTreeLength(TreeNode root) {
        if (root == null) return 0;
        return Integer.max(getTreeLength(root.left) + 1, getTreeLength(root.right) + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int height = getTreeLength(root);
        boolean flag = true;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();

        left.add(root);

        for (int i = 0; i < height; i ++) {
            List<Integer> list = new ArrayList<>();
            if (flag)
                while (!left.isEmpty()) {
                    TreeNode temp = left.pop();
                    if (temp.left != null) right.add(temp.left);
                    if (temp.right != null) right.add(temp.right);
                    list.add(temp.val);
            } else
                while (!right.isEmpty()) {
                    TreeNode temp = right.pop();
                    if (temp.right != null) left.add(temp.right);
                    if (temp.left != null) left.add(temp.left);
                    list.add(temp.val);
                }
            flag = !flag;
            result.add(list);
        }
        return result;
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

        List<List<Integer>> lists = zigzagLevelOrder(t1);
        for (List list: lists) {
            System.out.println(list);
        }
    }
}
