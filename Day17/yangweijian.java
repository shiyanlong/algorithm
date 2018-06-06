import org.junit.Test;

import java.util.Stack;

public class Day17 {

    private int reckon(int i1, int i2, char c) {
        switch (c) {
            case '+' : return i2 + i1;
            case '-': return i2 - i1;
        }
        return 0;
    }

    public int calculate(String s) {
        Stack<Character> o = new Stack<>();
        Stack<Integer> n = new Stack<>();
        int i1, i2;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            if (c == '(') {
                o.push(c);
            } else if (c == '+' || c == '-') {
                if (!o.isEmpty() && o.peek() != '(') {
                    i1 = n.pop();
                    i2 = n.pop();
                    n.push(reckon(i1, i2, o.pop()));
                }
                o.push(c);
            } else if (c == ')') {
                while (!o.isEmpty()) {
                    char temp = o.pop();
                    if (temp != '(') {
                        i1 = n.pop();
                        i2 = n.pop();
                        n.push(reckon(i1, i2, temp));
                    } else break;
                }
            } else if (c != ' '){
                int j;
                for (j = i + 1; j < chars.length; j++) {
                    if (chars[j] == '(' ||
                            chars[j] == '+' ||
                            chars[j] == '-' ||
                            chars[j] == ')' ||
                            chars[j] == ' ') {
                        n.push(Integer.parseInt(s.substring(i, j)));
                        i = j - 1;
                        break;
                    }
                }
                if (j == chars.length) {
                    n.push(Integer.parseInt(s.substring(i, j)));
                    i = j - 1;
                }
            }
        }

        while (!o.isEmpty()) {
            i1 = n.pop();
            i2 = n.pop();
            n.push(reckon(i1, i2, o.pop()));
        }
        return n.pop();
    }

    @Test
    public void a() {
        System.out.println(calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
    }
}
