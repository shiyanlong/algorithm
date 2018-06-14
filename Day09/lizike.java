/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode list = head;
        ListNode flag = head;
        ListNode list1 = new ListNode(0);
        if(head == null || head.next == null){
            return head;
        }
        head = head.next;
        while(list.next != null){
            flag = list.next;
            list.next = flag.next;
            flag.next = list;
            list1.next = flag;
            if(list.next != null){
                list1 = list;
                list = list.next;
            }
        }
        return head;
    }
}