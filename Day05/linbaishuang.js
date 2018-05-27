const sum = function sum() {
    var arr = new Array();
    arr =[[1,3,1],[1,5,1],[4,2,1]];
    var row = arr.length;
    var col = arr[0].length;
    for(var i=row-2;i>=0;i--){
        arr[i][col-1] +=  arr[i+1][col-1];
    }
    for(var j=col-2;j>=0;j--){
        arr[row-1][j] += arr[row-1][j+1];
    }
    for(var m=row-2;m>=0;m--){
        for(var n=col-2;n>=0;n--){
            arr[m][n] += Math.min(arr[m+1][n],arr[m][n+1]);
        }
    }
    console.log(arr[0][0]);
};
 module.exports = sum;