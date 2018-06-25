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

list.add(),��ӵ������ã��ݹ���õ�ʱ����Ϊֻ��һ�����ã����ÿ�ζ����������ã�Ȼ�����������ã����ͻ����Ӧ������newһ����������ӡ�