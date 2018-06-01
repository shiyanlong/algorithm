package study;

import org.junit.Test;

import java.util.Stack;

public class EightQueens {

    private class Queen {
        int x;
        int y;
        Queen(int x, int y) {this.x = x;this.y = y; }

        @Override
        public String toString() {return "(" + this.x + ", " + this.y + ")";}
    }

    public void solute(int n) {
        Stack<Queen> stack = new Stack<>();
        Queen q = new Queen(1, 1);
        int len = 0;
        while (len < n) {
            if (q.x > n || q.y > n) {
                q = stack.pop();
                q.x ++;
                len --;
            } else {
                if (!isCan(stack, q)) q.x ++;
                else {
                    stack.push(q);
                    q = new Queen(1, q.y + 1);
                    len ++;
                }
            }
        }

        while (!stack.isEmpty()) {
            Queen queen = stack.pop();
            System.out.println(queen);
        }
    }

    private boolean isCan(Stack<Queen> stack, Queen q) {
        Stack<Queen> s = (Stack<Queen>) stack.clone();
        while (!s.isEmpty()) {
            Queen cq = s.pop();
            if (cq.x == q.x ||
                    cq.y == q.y ||
                    Math.abs(q.x - cq.x) == Math.abs(q.y - cq.y))
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        solute(4);
    }
}
