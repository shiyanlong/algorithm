/**
 * @param {number[]} nums
 * @return {boolean}
 */
var find132pattern = function(nums) {
    var len = nums.length;
    if(len <= 2){
        return false;
    }
    for(var i = len - 1;i>=2;i--){  
        var j = i - 1;      //代表最大数
        var k = 0;          //代表最小数
        while(j > k){  
            if(nums[i] > nums[k] && nums[i] < nums[j]) return true;  
            if(nums[i] <= nums[k]) k++;  
            if(nums[i] >= nums[j]) j--;  
        }  
    }  
    return false;  
};