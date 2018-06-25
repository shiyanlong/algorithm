/*给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。*/
let num = "43214321";
let k = 4;

function removeKdigits(num,k){
    let len = num.length;
    let stack = [];
    let del = k;
    if(len === del) return '0';
    for(let i in num){
        if (stack.length === 0 ) {
            stack.push(num[i]);
        }else{
            while(num[i] < stack[stack.length-1] && del !==0){
                stack.pop();
                del --;
            }
            stack.push(num[i]);
        }
    }
    stack = stack.join("").slice(0,len - k);
    if(parseInt(stack[0]) !== 0){
        return stack;
    }else{
        for(let i = 0;;){
            if(parseInt(stack[i]) !== 0){
                stack = stack.slice(i);
                return stack;
            }else if(i === stack.length -1){
                return "0";
            }else{
                i ++;
            }
        }
    }
}
console.log(removeKdigits(num,k));


