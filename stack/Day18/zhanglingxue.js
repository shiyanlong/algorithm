/*有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
输入: ["4", "13", "5", "/", "+"]
输出: 6
解释: (4 + (13 / 5)) = 6*/
var s = ["4", "13", "5", "/", "+"];
function Stack(s){
    var st = [];
    var temp;
    var min,max;
    for(var i in  s){
        var n = s[i];
        switch (n){
            case "+":
                temp = parseInt(st.pop()) + parseInt(st.pop());
                st.push(temp);
                break;
            case "-":
                min = st.pop();
                max = st.pop();
                temp = max - min;
                st.push(temp);
                break;
            case "*":
                temp = st.pop() * st.pop();
                st.push(temp);
                break;
            case "/":
                min = st.pop();
                max = st.pop();
                temp = parseInt(max / min);
                st.push(temp);
                break;
            default:
                st.push(n);
                break;
        }
    }
    return parseInt(st.pop());
}
console.log(Stack(s));