/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
输入: "([)]"
输出: false*/
var s = "()[]";
function stack() {
    this.dataStore = [];//保存栈内元素，初始化为一个空数组
    this.top = 0;//栈顶位置，初始化为0
    this.push = push;//入栈
    this.pop = pop;//出栈
}
function push(element){
    this.dataStore[this.top++] = element;
}
function pop(){
    return this.dataStore[--this.top];
}
function isValid(s) {
    var st = new stack();
    if(s.length%2 !== 0){
        return false;
    }
    var temp = true;
    for(var i in s){
        if(s[i] === "("|| s[i] === "["|| s[i] === "{"){
            st.push(s[i]);
        }else{
            var c = s[i];
            switch (c){
                case ")":
                    if(st.pop() !== "(") return false;
                    else break;
                case "]":
                    if(st.pop() !== "[") return false;
                    else break;
                case "}":
                    if(st.pop() !== "{") return false;
                    else break;
            }
        }
    }
    if(st.top !== 0){
        temp = false;
    }
    return temp;
}
console.log(isValid(s));

/*给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
输入：S = "abd##c", T = "ab#d#c"
输出：true
解释：S 和 T 都会变成 “ac”。*/
var S = "abd##c";
var T = "ab#d#c";
function Stack(S,T) {
    var st1 = [];
    var st2 = [];
    for(var i in S){
        if(S[i] !== "#"){
            st1.push(S[i]);
        }else{
            st1.pop();
        }
    }
    S = st1.join("");
    for(var i in T){
        if(T[i] !== "#"){
            st2.push(T[i]);
        }else{
            st2.pop();
        }
    }
    T = st2.join("");
    return (S == T);
}
console.log(Stack(S,T));