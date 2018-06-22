/*给定一个二叉树，返回它的 前序 遍历。
输入: [1,null,2,3,6,4,5]
   1
    \
     2
    / \
   3   6
  / \
 4   5
输出: [1,2,3,4,5,6]*/
var TreeNode = function(val) {
    this.val = val;
    this.left = null;
    this.right = null;
};
var root = new TreeNode(1);
var r1 = new TreeNode(7);
var r2 = new TreeNode(2);
var r3 = new TreeNode(3);
var r4 = new TreeNode(4);
var r5 = new TreeNode(5);
var r6 = new TreeNode(6);
root.right = r2;
// root.left = r1;
r2.left = r3;
r2.right = r6;
r3.left = r4;
r3.right = r5;
// function Tree(root) {
//     if(root === null){
//         return arr;
//     }
//     math(root,arr);
//     return arr;
// }
// function math(root,arr){
//     arr.push(root.val);
//     if(root.left !== null){
//         math(root.left,arr);
//     }
//     if(root.right !== null){
//         math(root.right,arr);
//     }
// }
function Tree(root){
    var stack = [];
    var arr = [];
    var pre = null;
    var top = null;
    var index = root;
    while(index !== null||stack.length !== 0)
    {
        //先序迭代
        while(index !== null)
        {
            arr.push(index.val);
            stack.push(index);
            index = index.left;
        }
        if(stack.length !== 0)
        {
            index=stack.pop();
            index = index.right;
        }
        //中序迭代
        while(index !== null){
            stack.push(index);
            index = index.left;
        }
        if(stack.length !== 0){
            index = stack.pop();
            arr.push(index.val);
            index = index.right;
        }
        //后序迭代
        while(index !== null){
            stack.push(index);
            index = index.left;
        }
        index = stack[stack.length - 1];
        if(index.right === null || index.right === pre){
            arr.push(index.val);
            pre = index;
            index = null;
            stack.pop();
        }else{
            index = index.right;
        }
    }
    return arr;
}
console.log(Tree(root));