/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    var arr1 = new Array();
    var arr2 = new Array();
    if(root === null) return null;
    arr1.push(root);
    arr2.push(root.val);
    for(var i = 0; i < arr1.length; i++){
        if(arr1[i] !== "null"){
            if(arr1[i].left !== null){
                arr1.push(arr1[i].left);
                arr2.push(arr1[i].left.val);
            } else {
                arr2.push("null");
            }
            if(arr1[i].right){
                arr1.push(arr1[i].right);
                arr2.push(arr1[i].right.val);
            }else {
                arr2.push("null");
            }
        }
    }
    for(var j = arr2.length-1; j >= 0; j--){
        if(arr2[j] !== "null") break;
        arr2.splice(j, 1);
    }
    return arr2;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    var indexleft = 0;
    var parent = "";
    var head = "";
    var arr1 = new Array();
    if(data === null) return null;
    for(var i = 0; i < data.length;i++){
        if(data[i] > -1000000 && data[i] <= 100000){
            var node = new TreeNode(data[i]);
            arr1.push(node);
            if(parent){
                if(parent.left === null && indexleft !== 1 && parent.right === null){
                    parent.left = node;   
                    indexleft = 1;
                    continue;
                } else if(parent.left !== null && parent.right === null){
                    parent.right = node;
                    arr1.splice(0, 1);
                    parent = arr1[0];
                    indexleft = 0;
                } else if(parent.left === null && indexleft === 1 && parent.right === null){
                    parent.right = node;
                    arr1.splice(0, 1);
                    parent = arr1[0];
                    indexleft = 0;
                }
            } else {
                head = node;
                parent = arr1[0];
            }
        } else if(data[i] === "null"){ 
            if(indexleft === 0 && parent.left === null){
                indexleft = 1;
            } else if(indexleft === 1){
                arr1.splice(0, 1);
                parent = arr1[0];
                console.log(parent);
                indexleft = 0;
            }  
        }
    }
    return head;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */