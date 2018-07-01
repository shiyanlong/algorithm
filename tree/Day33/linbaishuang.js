/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {
    if(root === null) return;
    var head = root;
    var arr1 = new Array();
    helper(root, arr1); 
};
var helper = function(root, arr1){
    if(root === null) return;
    if(root.left){
        if(root.right){
            arr1.push(root.right);
        }        
        root.right = root.left;
        root.left = null;
        helper(root.right, arr1);
    } else if(root.right){
        helper(root.right, arr1);
    } else if(root.left === null && root.right === null && arr1.length > 0){
        var node = arr1[arr1.length - 1];
        arr1.splice(arr1.length - 1, 1);
        root.right = node;
        helper(node, arr1);
    }  else if(root.left === null && root.right === null && arr1.length === 0){
        return;
    }
}