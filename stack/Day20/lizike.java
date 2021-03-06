/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        inTraversal(root,list);
        return list;
    }
    
    
    public void inTraversal(TreeNode root,List<Integer> list){
        if(root.left != null){
            inTraversal(root.left,list);
        }
        list.add(root.val);
        if(root.right != null){
            inTraversal(root.right,list);
        }
    }
}