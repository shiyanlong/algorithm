/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode list = new ListNode(0);
        ListNode list3 = list;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                list.next = list1;
                list = list.next;
                list1 = list1.next;
            }else{
                list.next = list2;
                list = list.next;
                list2 = list.next;
            }
        }
        if(list1 == null){
            list.next = list2;
        }
        if(list2 == null){
            list.next = list1;
        }
        return list3.next;
            
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       ListNode list = head;
        if(list == null || list.next==null){
            return head;
        }
       while(list.next != null){
           if(list.val == list.next.val){
               if(list.next.next != null){
                
                   list.next = list.next.next;                
               }else{
                   list.next=null;
               }
           }else{
               list = list.next;
           }
       }
        return head;
    }    
    }
