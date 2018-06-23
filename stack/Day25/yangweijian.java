import org.junit.Test;

import java.util.Stack;

public class Day25 {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i ++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k --;
            }
            stack.push(c);
        }
        while (k > 0) {
            stack.pop();
            k --;
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0? "0": sb.toString();
    }

    @Test
    public void test() {
        System.out.println(removeKdigits("10", 2));
    }
}
