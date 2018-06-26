import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> firstQueue = new LinkedList<>();
        Queue<TreeLinkNode> secondQueue = new LinkedList<>();
        firstQueue.offer(root);
        TreeLinkNode t;
        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            if (!firstQueue.isEmpty()) {
                while (!firstQueue.isEmpty()) {
                    t = firstQueue.poll();
                    if (t != null) {
                        if (!firstQueue.isEmpty()){
                            t.next = firstQueue.peek();
                        }
                        secondQueue.offer(t.left);
                        secondQueue.offer(t.right);
                    }
                }
            } else {
                while (!secondQueue.isEmpty()) {
                    t = secondQueue.poll();
                    if (t != null) {
                        if (!secondQueue.isEmpty()){
                            t.next = secondQueue.peek();
                        }
                        firstQueue.offer(t.left);
                        firstQueue.offer(t.right);
                    }
                }
            }
        }
    }
}
