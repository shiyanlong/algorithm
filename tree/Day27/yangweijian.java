import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day27 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<List<Integer>> get(TreeNode root, int sum, int cur, List<List<Integer>> result, Integer[] temp, int index) {
        if (cur == sum && root.left == null && root.right == null) {
            temp[index] = root.val;
            result.add(Arrays.asList(Arrays.copyOfRange(temp, 0, index + 1)));
            return result;
        }
        temp[index] = root.val;
        if (root.left != null) result = get(root.left, sum, cur + root.left.val, result, temp, index + 1);
        if (root.right != null) result = get(root.right, sum, cur + root.right.val, result, temp, index + 1);
        return result;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        return get(root, sum, root.val, new ArrayList<>(), new Integer[1024], 0);
    }
}
