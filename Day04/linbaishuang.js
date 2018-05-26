const three = function three() {
    var arr = new Array();
    var arr0 = new Array();     //存0
    var arr1 = new Array();     //存最后结果 二维数组
    arr = [-1,0,1,-1,2,4];
    var len = arr.length;
    var result = 0;
    var len0 = 0;
    arr.forEach(function (value, index, arr) {
       if(value === 0){
           arr0.push(0);
           arr.splice(index, 1);
       }
    });
    len0 = arr0.length;
    for(var i=0;i<len;i++){
        for(var j=i+1;j<len-1;j++){
            var arr2 = new Array();     //存每次遍历生成的数组
            result = arr[i] + arr[j];
            arr2.push(arr[i],arr[j]);
            if(result === 0){
                if(len0 !== 0){
                    arr2.push(0);
                    arr1.push(arr2.sort());
                }
            } else {
                arr.forEach(function (value, index, arr) {
                    if(value === (-result) && index !== i && index !== j){
                        arr2.push(value);
                        arr1.push(arr2.sort());
                    }
                });
            }
        }
    }
    var lens = arr1.length;
    for(var m=0;m<lens;m++){
        var flag = 0;
        for(var k=m+1;k<lens;k++){
            for(var n=0;n<3;n++){
                if(arr1[m][n] === arr1[k][n]){
                    flag++;
                }
                if(flag >= 2){
                    arr1.splice(k,1);
                    lens--;
                }
            }
        }
    }
    console.log(arr1);
};
module.exports = three;
