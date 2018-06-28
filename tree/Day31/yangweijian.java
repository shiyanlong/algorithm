import java.util.ArrayList;
import java.util.List;

public class Dya31 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode t = new TreeNode(v);
            t.left = root;
            return t;
        }

        // 拿到当前 d - 1 的那层的所有节点
        List<TreeNode> parents = new ArrayList<>();
        d -= 1;
        for (int i = 0; i < d; i ++) {
            if (parents.size() == 0) parents.add(root);
            else {
                int size = parents.size();
                for (int j = 0; j < size; j ++) {
                    TreeNode temp = parents.get(0);
                    parents.remove(temp);
                    if (temp.left != null) parents.add(temp.left);
                    if (temp.right != null) parents.add(temp.right);
                }
            }
        }

        parents.forEach(treeNode -> {
            TreeNode left = treeNode.left;
            treeNode.left = new TreeNode(v);
            treeNode.left.left = left;
            TreeNode right = treeNode.right;
            treeNode.right = new TreeNode(v);
            treeNode.right.right = right;
        });
        return root;
    }
}
