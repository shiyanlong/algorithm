--------------------------------------1-------------------------------------
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
var maxDepth = function(root) {
    var flag = 0;
    var index = 0;
    var arr1 = new Array();
    helper(root, flag, arr1);
    for(var i=0;i<arr1.length;i++){
        if(arr1[i] > index){
            index = arr1[i];
        }
    }
    return index;
};
var helper = function(root, flag, arr1){
    if(root === null) {
        arr1.push(flag);
        return;
    }
    flag++;
    helper(root.left, flag, arr1);    
    helper(root.right, flag, arr1);
}


------------------------------------------2------------------------------------------------
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function(p, q) {
    var arr1 = new Array();
    var flag = true;
    if(p === null && q === null){
        return true;
    }
    helper(p, q, flag, arr1);
    for(var i=0;i<arr1.length;i++){
        if(arr1[i] === false){
            return false;
        }
    }
    return true;
};
var helper = function(p, q, flag, arr1){
    if(p === null && q === null){
        return;
    } else if(p === null || q === null){
        flag = false;
        arr1.push(flag);
        return;
    }
    if(p && q){
        if(p.val !== q.val){
            flag = false;
            arr1.push(flag);
            return;
        } else {
            arr1.push(flag);
            helper(p.left, q.left, flag, arr1);
            helper(p.right, q.right, flag, arr1);
        }
    }
}