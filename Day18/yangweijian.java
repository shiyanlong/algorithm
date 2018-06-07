package study.stack;

import java.util.Stack;

public class Day18 {

    private int reckon(int i1, int i2, String c) {
        switch (c) {
            case "+" : return i2 + i1;
            case "-" : return i2 - i1;
            case "*" : return i2 * i1;
            case "/" : return i2 / i1;
        }
        return 0;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> n = new Stack<>();
        int i1, i2;

        for (String str: tokens) {
            if (str.equals("+") ||
                    str.equals("-") ||
                    str.equals("*") ||
                    str.equals("/")) {
                i1 = n.pop();
                i2 = n.pop();
                n.push(reckon(i1, i2, str));
            } else n.push(Integer.parseInt(str));
        }

        return n.pop();
    }
}
