public class Day06 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private class Solute {

        private ListNode q1(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode head = result;

            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    head.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    head.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                head = head.next;
            }

            ListNode n = l1 != null? l1: l2;

            while (n != null) {
                head.next = new ListNode(n.val);
                head = head.next;
                n = n.next;
            }
            return result.next;
        }

        private ListNode q2(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode h = head;
            while (h != null) {
                ListNode hl = h.next;
                while (hl != null && hl.val == h.val) {
                    hl = hl.next;
                }
                h.next = hl;
                h = hl;
            }
            return head;
        }
    }
}
