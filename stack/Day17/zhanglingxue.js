/*实现一个基本的计算器来计算一个简单的字符串表达式的值。
* 输入: "(1+(4+5+2)-3)+(6+8)"
字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格
输出: 23*/
var s = "(1+(4+5+2)-3)+(6+8)";
function Stack(s) {
    var st1 = [];//符号栈
    var st2 = [];//数栈
    var min ,max ,temp;
    for(var i in s){
        var n = s[i];
        if(n === "("){
            st1.push(n);
        }else if(n === "+" || n ==="-"){
            if(st1.length !== 0) {
                if (st1[st1.length - 1] === "+") {
                    min = parseInt(st2.pop());
                    max = parseInt(st2.pop());
                    st1.pop();
                    temp = min + max;
                    st2.push(temp);
                    st1.push(n);
                } else if (st1[st1.length - 1] === "-") {
                    min = parseInt(st2.pop());
                    max = parseInt(st2.pop());
                    st1.pop();
                    temp = max - min;
                    st2.push(temp);
                    st1.push(n);
                } else {
                    st1.push(n);
                }
            }else{
                st1.push(n);
            }
        }else if(n === ")"){
            if(st1[st1.length-1] === "("){
                st1.pop();
            }else if(st2.length >= 2){
                min = parseInt(st2.pop());
                max = parseInt(st2.pop());
                var m = st1.pop();
                if(m === "+"){
                    temp = min + max;
                }else if(m === "-"){
                    temp = max - min;
                }else if(m === "("){
                    continue;
                }
                st2.push(temp);
                st1.pop();
            }else{
               return parseInt(st2.pop());
            }
        }else if(n === " "){
            continue;
        }else{
            if(i >= 1 && s[i-1] !== "(" && s[i-1] !== "-" && s[i-1] !== "+" && s[i-1] !== " "){
                st2[st2.length-1] += n;
            }else{
                st2.push(n);
            }
        }
    }
    if(st1.length !== 0){
        min = parseInt(st2.pop());
        max = parseInt(st2.pop());
        if(st1[0] === "+"){
            temp = max + min;
        }else{
            temp = max - min;
        }
        st2.push(temp);
    }else if(st1.length === 0 && st2.length !== 0){
        temp = st2.join("");
        for(var i in st2){
            st2.pop();
        }
        st2.push(temp);
    }
    return parseInt(st2.pop());
}
console.log(Stack(s));