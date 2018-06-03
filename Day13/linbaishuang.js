var combine = function(n, k) {
    if(k<0 || n<1 || k>n){
        return result;
    } else {
        var arr = new Array();
        var result = new Array();
        calculate(result, arr, k, n, 1);
        return result;
    }
};
var calculate = function(result, arr, k, n, start){
    if(arr.length === k){ 
        var ar = new Array();
        for(var i=0;i<k;i++){
            ar[i] = arr[i];
        }
        result.push(ar);
    } else {
        for(var i=start;i<=n;i++){
            arr.push(i);
            calculate(result, arr, k, n, i+1);
            arr.pop();
        }
    }
    return;
}