/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
输入: "([)]"
输出: false*/
var s = "([)]";
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
    for(var i = 0;i < s.length;i ++){
        if(s[i] === "("|| s[i] === "["|| s[i] === "{"){
            st.push(s[i]);
        }
        if(s[i] === ")"){
            if(st.pop() === "("){
                temp = true;
            }else{
                return false;
            }
        }
        if(s[i] === "]"){
            if(st.pop() === "["){
                temp = true;
            }else{
                return false;
            }
        }
        if(s[i] === "}"){
            if(st.pop() === "{"){
                temp = true;
            }else{
                return false;
            }
        }
    }
    if(st.top !== 0){
        temp = false;
    }
    return temp;
}
console.log(isValid(s));