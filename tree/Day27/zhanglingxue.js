/*给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。说明: 叶子节点是指没有子节点的节点。
给定如下二叉树，以及目标和 sum = 22,==>[[5,4,11,2],[5,8,4,5]]
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1   */
        let TreeNode = function(val) {
            this.val = val;
            this.left = null;
            this.right = null;
        };
        let root = new TreeNode(5);
        let r1 = new TreeNode(4);
        let r2 = new TreeNode(8);
        let r3 = new TreeNode(11);
        let r4 = new TreeNode(13);
        let r5 = new TreeNode(4);
        let r6 = new TreeNode(7);
        let r7 = new TreeNode(2);
        let r8 = new TreeNode(5);
        let r9 = new TreeNode(1);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r5.left = r8;
        r5.right = r9;
        let sum = 22;
        let ans = [];
        let temp = [];
        function pathSum(root,sum) {
            dfs(root,sum);
            return ans;
        }
        function dfs(root,sum) {
            if(root === null) return;
            temp.push(root.val);
            if(root.val === sum && root.right === null && root.left === null){
                let arr = Array.from(temp);
                ans.push(arr);
            }
            dfs(root.left,sum - root.val);
            dfs(root.right,sum - root.val);
            temp.pop();
        }
        console.log(pathSum(root,sum));