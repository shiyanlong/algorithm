/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode list = head;
        ListNode list1 = head;
        int i = 1;
        ListNode newHead = new ListNode(0);
        ListNode list2 = newHead;
        if(list == null){
            return head;
        }else if(list.next == null){
            return head;
        }else{
            while(list.next != null){
            list = list.next;
            i++;
        }
        if(k % i == 0){
            return head;
        }else{
            k =  k % i;
            int z = i - k;
            int j = 1;
            while(z > j){
                list1 = list1.next;
                j++;
            }
            
            newHead = list1.next;
            list2 = newHead;
            list1.next = null;
            while(k>1){
                newHead = newHead.next;
                k--;
            }
            newHead.next = head;
           
        }
        return list2;
        }
        
        
    }
}