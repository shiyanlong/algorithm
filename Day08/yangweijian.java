import org.junit.Test;

public class Day08 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode l = head;
        int len = 0;
        while (l != null) {
            l = l.next;
            len ++;
        }
        if (len == 0)
            return null;
        int realLen = len - (k % len);
        l = head;
        while (realLen > 1) {
            l = l.next;
            realLen --;
        }
        ListNode next = l.next;
        l.next = null;
        if (next == null) {
            return head;
        } else {
            ListNode temp = next;
            while (temp.next != null)
                temp = temp.next;
            temp.next = head;
            return next;
        }
    }

    @Test
    public void a() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;

        l1 = rotateRight(l1, 2);

        while (l1 != null) {
            System.out.print(l1.val);
            System.out.print("  ->  ");
            l1 = l1.next;
        }
    }
}
