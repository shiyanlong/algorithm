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
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int sum=0;
        int temp = 0;
        tra(root,list,temp);
        for(int i=0;i<list.size();i++){
            sum += list.get(i);
        }
        return sum;
    }
    
    public void tra(TreeNode root,List<Integer> list,int temp){
        if(root == null){
            return;
        }
        temp = temp *10 + root.val;
        if(root.left==null && root.right == null){
            list.add(temp);
        }
        tra(root.left,list,temp);
        tra(root.right,list,temp);
        temp /= 10;
    }
}