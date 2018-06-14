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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        postTraversal(root,list);
        return list;
    }
    
    public void postTraversal(TreeNode root,List<Integer> list){
        if(root.left != null){
            postTraversal(root.left,list);
        }
        
        if(root.right != null){
            postTraversal(root.right,list);
        }
        list.add(root.val);
    }
}