/**
两数组相乘返回结果数组
例如：
var arr = [9,7];
var arr2 = [9,5,3];
console.log([9,2,4,4,1]);
 */
function alg(){
    var arr = [9,7];
    var arr2 = [9,5,3];
    var sum = [];
    for(var i = arr2.length-1;i >= 0;i --){
        var array = [];
        for(var j = 0;j < arr.length;j ++){
            array.push(arr2[i]*arr[j]);//遍历相乘
        }
        for(var m = array.length-1;m > 0;m --){//进位
            if(array[m] >= 10){
                var num = parseInt(array[m]/10);//得到十位数的数值
                array[m] -= num*10;//由两位数变一位数
                array[m-1] += num;
            }
        }
        if(array[0] >= 10){//数组第0位单独列
            var num = parseInt(array[0]/10);
            array[0] -= num*10;
            array.unshift(num) //数组开头加上元素
        }
        sum.push(array);
    }
    var c =[];
    for(var i = sum.length-1;i > 0;i --){
        sum[i].push(0); //最后一个数组末尾补0，两数组从最后相加
        var num = sum[i].length - sum[i-1].length;
        for(var j = 0;j <num;j++){
            sum[i-1].splice(0,0,0);
        }
        for(var m = 0;m < sum[i].length;m ++){
            sum[i-1][m] += sum[i][m];
        }
    }
    for(var i = sum[0].length-1;i > 0;i--){
        if(sum[0][i] > 9){
            sum[0][i] -= 10;
            sum[0][i-1] += 1;
        }
    }
    if(sum[0][0] > 9){
        sum[0][0] -= 10;
        sum[0].unshift(1);
    }
    return sum[0];
}
console.log(alg());