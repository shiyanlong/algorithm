$("body").on("click", "#showdele", function () {
    testdele();
});

$("body").on("click", "#showaddone", function () {
    testadd();
});

$("body").on("click", "#showaddtwo", function () {
    addtwo();
});

function testdele() {
    var arr = new Array();
    var num = $("#delenum").val();
    var len = num.length;
    var deleone = $("#deleone").val();
    for(var i=0;i<100 ;i++){
        if(i < len){
            arr[i] = num[i];
        }
    }
    if(deleone === "0" || deleone === len){
        arr.splice(deleone,deleone+1);
    } else {
        arr.splice(deleone,deleone);
    }
    alert(arr);
}

function testadd() {
    var arr1 = new Array();
    // var n = Math.floor(Math.random()*1000).toString();
    var n = "123";
    var len = n.length;
    var flag = 0;
    for(var i=0;i<1001;i++){
        if(i < len){
            arr1[i] = n[i];
        }
    }
    alert(arr1);

    for(var j=len-1;j>=0; j--){
        if(arr1[j] === "9"){
            flag = 1;
            arr1[j] = 0;
        } else {
            arr1[j] = parseInt(arr1[j]) + 1;
            flag = 0;
            j= -1;
        }
    }
    if(flag){
        for(var k=0;k< len; k++){
            arr1[k+1] = arr1[k]
        }
        arr1[0] = 1;
    }
    alert(arr1);
}

function addtwo() {
    var arr2 = new Array();
    var arr3 = new Array();
    arr2 = [9,9];
    arr3 = [1,1];
    var num = 0;
    var flag = 0;
    var len1 = arr2.length;
    var len2 = arr3.length;
    var len = len2-len1;
    for(var i=len1-1,j=len2-1;i>=0,j>=len;i--,j--){
        if(j>=0 && i>=0){
            num = (parseInt(arr2[i]) + parseInt(arr3[j]) + flag).toString();
        } else {
            num = (parseInt(arr2[i]) + flag).toString();
        }
        flag = 0;
        if(num.length === 2){
            flag = 1;
            arr2[i] = num[1];
        } else {
            arr2[i] = num[0];
        }
    }
    if(flag){
        for(var m=len1;m>0;m--){
            arr2[m] = arr2[m-1];
        }
        arr2[0] = 1;
    }
    alert(arr2);
}