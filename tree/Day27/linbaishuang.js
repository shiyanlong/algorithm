/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum = function(root, sum) {
    var arr1 = new Array();
    var arr2 = new Array();
    if(root === null) return arr2;
    helper(root, sum, arr1, arr2);
    return arr2;
};
var helper = function(root, sum, arr1, arr2){
    if(root === null) return;
    arr1.push(root.val);
    if(root.left === null && root.right === null){
        if(sum === root.val){
            var a = Array.from(arr1);
            arr2.push(a);
        }
        arr1.pop();
        return;
    }
    helper(root.left, sum-root.val, arr1, arr2);
    helper(root.right, sum-root.val, arr1, arr2);
    arr1.pop();
}