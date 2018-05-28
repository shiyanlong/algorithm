package study;

public class Day07 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private class Solute {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode tempListNode = result;

            while (l1 != null && l2 != null) {
                tempListNode.next = new ListNode(l1.val + l2.val);
                tempListNode = tempListNode.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            tempListNode.next = l1 == null? l2: l1;;
            ListNode l = result;

            while (l.next != null) {
                if (l.val >= 10) {
                    int temp = l.val;
                    l.val = temp - 10;
                    l.next.val += 1;
                }
                l = l.next;
            }

            if (l.val >= 10) {
                l.val -= 10;
                l.next = new ListNode(1);
            }
            return result.next;
        }
    }
}
