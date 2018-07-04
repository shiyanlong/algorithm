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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode nroot = new TreeNode(v);
            nroot.left = root;
            return nroot;
        }else{
            trav(root,v,d-1,1);
            return root;
        }
        
    }
    
    public void trav(TreeNode root,int v,int d,int depth){
        if(root == null){
            return;
        }
        if(depth != d){
            trav(root.left,v,d,depth+1);
            trav(root.right,v,d,depth+1);
        }
        if(depth == d){
            TreeNode lroot = new TreeNode(v);
            TreeNode rroot = new TreeNode(v);
           
            lroot.left = root.left;
            rroot.right = root.right;
            root.left = lroot;
            root.right = rroot;
        }
    }
}