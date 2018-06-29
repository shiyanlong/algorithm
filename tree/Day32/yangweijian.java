import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day32 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 向 result 中添加一个节点
     * @param result 结果集合
     * @param list 存储当前所处的行节点的集合
     * @param node 当前遍历的节点
     * @return 结果结合
     */
    private List<String> addNode(List<String> result, List<TreeNode> list, TreeNode node) {
        if (node != null) {
            result.add(String.valueOf(node.val));
            list.add(node);
        } else
            result.add("null");
        return result;
    }

    /**
     * 求树的高度
     * @param root 根节点
     * @return 高度
     */
    private int height(TreeNode root) {
        if (root == null) return 0;
        return Integer.max(height(root.left) + 1, height(root.right) + 1);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>(); // 结果结合
        List<TreeNode> list = new LinkedList<>(); // 存储每行节点的集合

        addNode(result, list, root); // 把根节点先放入进去，以便遍历

        int height = height(root) - 1; // 遍历的次数，由于先把根节点放在集合中，所以需要 - 1
        for (int i = 0; i < height; i ++) {
            int size = list.size();
            // 遍历行集合，每次都要走左节点、和右节点，添加进 result 集合中
            for (int j = 0; j < size; j ++) {
                TreeNode node = list.get(0);
                list.remove(node);
                result = addNode(result, list, node.left);
                result = addNode(result, list, node.right);
            }
        }

        // 删除集合最后的 null 字符串
        for (int i = result.size() -  1; i > 0; i --)
            if (result.get(i).equals("null")) result.remove(i);
            else break;
        return result.toString();
    }

    // ==============================================================================================

    /**
     * 根据 str 创建一个节点并返回
     * str 可能为 "" 或 "null"
     * @param str 字符窜
     * @return 节点
     */
    private TreeNode createNode(String str) {
        return str.equals("")? null: str.equals("null")? null: new TreeNode(Integer.valueOf(str));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 截取 data [] 之间的值
        data = data.substring(1, data.length() - 1);
        // 按照 ", " 进行切分
        String[] split = data.split(", ");
        TreeNode root = createNode(split[0]);

        List<TreeNode> list = new LinkedList<>();
        list.add(root);

        int index = 1;
        int len = split.length;
        // 每次在 list 中取出节点，判断 index 是否越界，把 index 和 index + 1 所对应的值，分别添加在 left 和 right 上
        while (index < len) {
            TreeNode temp = list.get(0);
            list.remove(temp);
            TreeNode t;
            t = createNode(split[index]);
            temp.left = t;
            if (t != null) list.add(t);
            if (index + 1 < len) {
                t = createNode(split[index + 1]);
                temp.right = t;
                if (t != null) list.add(t);
            }
            index += 2;
        }
        return root;
    }
}