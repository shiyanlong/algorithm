/**
 * Definition for binary tree with next pointer.
 * function TreeLinkNode(val) {
 *     this.val = val;
 *     this.left = this.right = this.next = null;
 * }
 */

/**
 * @param {TreeLinkNode} root
 * @return {void} Do not return anything, modify tree in-place instead.
 */
var connect = function(root) {
    if(root === null) return;
    var p = root.next;
    while(p){
        if(p.left){
            p = p.left;
            break;
        }
        if(p.right){
            p = p.right;
            break;
        }
        p = p.next;
    }
    if(root.right) root.right.next = p;
    if(root.left){
        root.left.next = root.right ? root.right : p;
    }
    connect(root.right);
    connect(root.left);  
};
