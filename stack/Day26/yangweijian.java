package study.stack;

import org.junit.Test;

import java.util.Stack;

public class Day26 {
    /*
    在 three 变量中存储第三个值：也就是第二大的，
    在栈中维护所有大于 three 的数，
    当遍历的时候，有小于 three 的话，那就返回 true
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int three = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i --) {
            if (nums[i] < three) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) three = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(find132pattern(new int[]{3,5,0,3,4}));
    }
}
