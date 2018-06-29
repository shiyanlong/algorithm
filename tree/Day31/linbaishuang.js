/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} v
 * @param {number} d
 * @return {TreeNode}
 */
var addOneRow = function(root, v, d) {
    if(root === null) return null;
    var head = new Array();
    head.push(root);
    helper(root, v, d, root, head);
    return head[head.length-1];
};
var helper = function(root, v, d, parent, head){
    if(root === null && d > 1) return;
    if(d === 1){
        if(parent === root){
            var node = new TreeNode(v);
            node.left = root;
            node.right = null;
            head.push(node);
        } else {
            if(parent.left === root){
                var node = new TreeNode(v);
                node.left = root;
                parent.left = node;
            } else if(parent.right === root){
                var node = new TreeNode(v);
                node.right = root;
                parent.right = node;
            }
        }
        return;
    }
    helper(root.left, v, d-1, root, head);
    helper(root.right, v, d-1, root, head);
}