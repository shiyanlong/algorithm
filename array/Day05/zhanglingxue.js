/*给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步*/
function algo() {
    var grid = [
        [1,3,1],
        [1,5,1],
        [4,2,1]
    ];
    var M = grid.length;
    var N = grid[0].length;
    for(var i=M-2; i>=0; i--){
        grid[i][N-1] += grid[i+1][N-1];
    }
    for(var j=N-2; j>=0; j--){
        grid[M-1][j] += grid[M-1][j+1];
    }
    for (var j=N-2; j>=0; j--)
        for (var i=M-2; i>=0; i--){
            grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
        }
    return grid[0][0];
}
console.log(algo());