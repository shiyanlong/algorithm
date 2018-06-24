class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if(len <3){
            return false;
        }
        for(int i=len-1;i>1;i--){
            int j = i-1;
            int k = 0;
            while(k < j){
                 if(nums[k] < nums[i] && nums[i] < nums[j]) return true;   
                if(nums[j] <= nums[i]) j--;     
                if(nums[i] <= nums[k]) k++;
               
            }   
        }
        return false;
    }
}