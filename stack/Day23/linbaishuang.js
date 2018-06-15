/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
    var arr1 = new Array();      //Êı×Ö
    var arr2 = new Array();      //×ÖÄ¸
    var num = "";
    for(var i=0;i<s.length;i++){
        if(/^[0-9]$/.test(s[i])){
            num += s[i]; 
            console.log(num)
        } else if(/^[a-zA-Z]$/.test(s[i]) || s[i] === '['){
            if(num){
                arr1.push(num);
            }
            num = "";
            arr2.push(s[i]);   
        } else if(s[i] === ']'){
            var index = "";
            var flag = "";
            while(arr2[arr2.length-1] !== '['){
                index = arr2[arr2.length-1]+ index.split(0);
                arr2.pop();
            }
            var a = arr1[arr1.length-1];
            arr1.pop();
            while(a){
                flag += index;
                a--;
            }
            arr2.pop();
            arr2.push(flag);
        }
    }
    return arr2.join('');
};