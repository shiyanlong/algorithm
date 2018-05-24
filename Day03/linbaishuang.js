//移动元素
const remove = function remove() {
    var arr = new Array();
    arr = [1,2,3,4,5,6,7,8,9];
    var k = 5;
    var arr1;
    var len = arr.length;
    if(k>0){
        arr1 = arr.slice(len-k,len);
        arr.splice(len-k,len);
    }
    arr1 = arr1.concat(arr);
    console.log(arr1);
};
module.exports = remove;

//排序
const order = function order() {
    var arr = new Array();
    var arr1 = new Array();
    arr = [0,1,3,7,5,0,8,9,4,2,0];
    var len = arr.length;
    var flag = 0;
    for(var i=0;i<len;){
        if(arr[i] === 0 && i === 0){
            arr.splice(0,1);
            arr1.push(0);
            i = i;
        }else if(arr[i] === 0 && i !== 0){
            arr.splice(i,1);
            arr1.push(0);
            i = i;
        } else {
            i++;
        }
    }
    flag = haleArr(arr).concat(arr1);
    console.log(flag);
};
function haleArr(arr) {
    var arr2 = new Array();     //大数
    var arr3 = new Array();     //小数
    var sum = 0;
    var len1 = arr.length;
    var half = 0;
    arr.forEach(function (vale, index, arr){
        sum = sum + vale;
    });
    if(arr.length > 1){
        half = parseInt(sum/len1);
        for(var i=0;i<len1;i++){
            if(arr[i]<=half){
                arr3.push(arr[i]);
                i=i;
            }else {
                arr2.push(arr[i]);
            }
        }
    }else{
        return arr;
    }
    return haleArr(arr3).concat(haleArr(arr2));
}
module.exports = order;