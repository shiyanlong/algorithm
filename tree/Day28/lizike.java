/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){return;}
        if (root.left != null) root.left.next = root.right;
        if (root.right != null) root.right.next = (root.next != null )? root.next.left : null;
        connect(root.left);
        connect(root.right);

    }
}


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        root.next = null;
        levelTraversal(root);
    }
    public void levelTraversal(TreeLinkNode root){
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.left != null && root.next != null){
            root.right.next = root.next.left;
            
        }
        if(root.left != null){
            levelTraversal(root.left);
        }
        if(root.right != null){
            levelTraversal(root.right);
        }
        
    }
}




