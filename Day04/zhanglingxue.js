/*数组中不重复的三个整数和为0的全部三元数组*/
function alg() {
    var arr = [-1, 0, 1, 2, -1, -4, -3];
    var all = [];
    var temp;
    for(var index = 0;index < arr.length-2;index ++){
        for(var i = index+1;i < arr.length-1;i ++){
            for(var j = i + 1;j < arr.length;j ++){
                var sum = arr[index]+arr[i]+arr[j];
                if(sum === 0){
                    var arr2 = [];
                    arr2.push(arr[index],arr[i],arr[j]);
                    arr2.sort();
                    for(var m = 0;m < all.length;m ++){
                        temp = false;
                        if(all[m].toString() === arr2.toString()){
                            temp = true;
                            break;
                        }
                    }
                    if(!temp){
                        all.push(arr2);
                    }
                }
            }
        }
    }
    return all;
}
console.log(alg());
