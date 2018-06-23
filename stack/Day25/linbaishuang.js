/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function(num, k) {
    var len = num.length;
    var arr = new Array();
    var top = 0;
    var index = "";
    if(len === k){
        return "0";
    } else if(k === 0){
        return num;
    } else {
        for(var i=0;i<len;i++){
            index = num[i];
            while(top > 0 && arr[top-1] > index && k > 0){
                arr.pop();
                top--;
                k--;
            }
            arr[top++] = index;
        } 
    }
    while(k > 0){
        arr.pop();
        k--;
    }                
    while(arr[0] === "0"){
        arr.splice(0, 1);
    }
    if(arr.length === 0){                   
        return "0";
    } else {
        return arr.join('');
    }
};