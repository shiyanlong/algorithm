/*给定一个二叉树，返回它的 前序 遍历。
输入: [1,null,2,3,6,4,5]
   1
    \
     2
    / \
   3   6
  / \
 4   5
输出: [1,2,3,4,5,6]*///问题在于判断不了空树！！
var TreeNode = function(val) {
    this.val = val;
    this.left = null;
    this.right = null;
};
var root = new TreeNode(1);
var r2 = new TreeNode(2);
var r3 = new TreeNode(3);
var r4 = new TreeNode(4);
var r5 = new TreeNode(5);
var r6 = new TreeNode(6);
root.right = r2;
r2.left = r3;
r2.right = r6;
r3.left = r4;
r3.right = r5;
var arr = [];
function Tree(root) {
    if(root === null){
        return ;
    }
    if(root){
        arr.push(root.val);
        Tree(root.left);
        Tree(root.right);
    }
    return arr;
}
console.log(Tree(root));