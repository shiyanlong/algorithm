/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
    var arr1 = new Array();     //一维数组
    var arr2 = new Array();     //一维数组
    var index = 0;
    if(root === null) return 0;
    helper(root, arr1, arr2);
    for(var i=0;i<arr2.length;i++){
        index += parseInt(arr2[i]);
    }
    return index;
};
var helper = function(root, arr1, arr2){
    arr1.push(root.val);
    if(root.left !== null){
        helper(root.left, arr1, arr2);
    }
    if(root.right !== null){
        helper(root.right, arr1, arr2);
    }
    if(root.left === null && root.right === null){
        let num = arr1.join('');
        arr2.push(num);
        console.log(arr2);
        arr1.pop();
        return;
    }
    arr1.pop();
}