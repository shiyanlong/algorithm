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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<Integer> intList = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;   
        }
        int nsum = 0;
        
        traversalPath(root,intList,nsum,list,sum);
        return list;
    }
    
    public void traversalPath(TreeNode root,List<Integer> intList,int nsum,List<List<Integer>> list,int sum){
        int a = root.val;
        intList.add(a);
        nsum = nsum+a;
        if(root.left != null){
            traversalPath(root.left,intList,nsum,list,sum);
        }
        if(root.right != null){
            traversalPath(root.right,intList,nsum,list,sum);
        }
        if(nsum == sum && root.left == null && root.right == null){
            List<Integer> newintList = new ArrayList<>();
            newintList.addAll(intList);
            list.add(newintList);
            for(int i=0;i<intList.size();i++){
                System.out.println(intList.get(i));
            }
            
        }
        
        int b = intList.remove(intList.size() -1);
        nsum = nsum-b;
    }
}

list.add(),添加的是引用，递归调用的时候因为只有一个引用，因此每次都清空这个引用，然后添加这个引用，，就会出错，应该重新new一个对象来添加。