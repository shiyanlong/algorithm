/*旋转数组，向右移k位*/
function algOne(){
    var arr = [1,2,3,4,5];
    var k = 3;
    //截取最后k位和除k位以外其他片段，合并两数组
    arr = arr.slice(-k).concat(arr.slice(0,arr.length-k));
    return arr;
}
console.log(algOne());

/*将数组中所有0提取到数组最后，其他数字顺序不变*/
function algTwo(){
    var arr = [0,2,0,5,6,9,0,8,0];
    var count = 0;
    var len = arr.length;
    for(var i = 0;i < len;i ++){
        if(arr[i] === 0){
            count ++;
            arr.splice(i,1);
            arr.push(0);
        }
    }
    return arr;
}
console.log(algTwo());
