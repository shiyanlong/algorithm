/*给定数组，删除指定数字*/
function algOne() {
    var arr = [1,2,3];
    arr.splice(1,1);
    return arr;
}
console.log(algOne());

/*数组加1*/
function algTwo(){
    var arr = [1,2,3];
    var arr2 = 1;
    var num = [];
    //数组元素转成字符串
    var num1 = arr.toString();  //9,9,9
    //字符串转数字
    var sum = parseInt(num1.replace(/,/g,'')) + arr2; //999+1
    for(var i in sum.toString()){
        num.push(parseInt(sum.toString()[i]));
    }
    return num;
}
console.log(algTwo());

/*两个数组相加*/
function algThree(){
    var arr = [9,9,9];
    var arr2 = [1];
    var num = [];
    //数组元素转成字符串
    var num1 = arr.toString();
    var num2 = arr2.toString();
    //字符串转数字
    var sum = parseInt(num1.replace(/,/g,''))+parseInt(num2.replace(/,/g,''));
    for(var i in sum.toString()){
        num.push(parseInt(sum.toString()[i]));
    }
    return num;
}
console.log(algThree());
