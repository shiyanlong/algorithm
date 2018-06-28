/*给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：
当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。*/
/*输入: [3, 1, 4, 2]
输出: True  解释: 序列中有 1 个132模式的子序列： [1, 4, 2].*/
let nums = [-1, 3, 2, 0];
function find132pattern(nums) {
    let len = nums.length;
    if(len < 3) return false;
    let stack = [];
    for(let i = 0;i < len;){
        if(!stack.length){
            stack.push(nums[i]);
            i ++;
        }else{
            if(nums[i] <= stack[stack.length-1]){  //如果循环的数值比栈顶元素小，放入
                stack.push(nums[i]);
                i ++;
            }else if(nums[i] - stack[stack.length-1] === 1){  //如果循环数值比栈顶元素大1，往下遍历
                i ++;
            }else{  
                let arr = [];
                for(let j = i+1;j < len;j ++){ //如果循环数值ak比栈顶元素ai(找到符合条件的最小ai)大且相差大于1，遍历循环数值后的数组
                    if(!arr.length && nums[j] < nums[i]){   
                        arr.push(nums[j]);
                    }else{
                        if(nums[j] > arr[arr.length-1] && nums[j] < nums[i]){  //如果数值aj大于新栈栈顶元素且小于循环数值ak,放入，找到符合条件的最大aj
                            arr.push(nums[j])
                        }
                    }
                }
                if(arr[arr.length-1] > stack[stack.length-1]){  //如果aj 》 ai
                    return true;
                }else{
                    i ++;
                }
            }
        }
    }
    return false;
}
console.log(find132pattern(nums));