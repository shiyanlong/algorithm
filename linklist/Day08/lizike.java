/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode list3 = list1;
        ListNode list4 = list2;
        ListNode list = head;
        while(list != null){
            if(list.val < x){
                list1.next = list;
                list1 = list1.next;
                list = list.next;
            }else{
                list2.next = list;
                list2 = list2.next;
                list = list.next;
            }
            
        }
        list2.next = null;
        list1.next = list4.next;
        return list3.next;
    }
}