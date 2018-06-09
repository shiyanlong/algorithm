import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Day16 {

    private String change(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c: str.toCharArray()) {
            if (c == '#' && stack.size() != 0)
                stack.pop();
            else if (c != '#')
                stack.push(c);
        }
        return stack.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        return change(S).equals(change(T));
    }

    @Test
    public void test1() {
        System.out.println(backspaceCompare("#a#v#", "a#n#"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (stack.size() == 0) return false;
            else {
                char temp = stack.pop();
                switch (c) {
                    case ')':
                        if (temp != '(') return false;
                        else break;
                    case ']':
                        if (temp != '[') return false;
                        else break;
                    case '}':
                        if (temp != '{') return false;
                        else break;
                }
            }
        }
        return stack.size() == 0;
    }

    @Test
    public void test2() {
        System.out.println(isValid("()"));
    }
}
