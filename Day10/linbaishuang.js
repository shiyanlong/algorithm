var swapPairs = function(head) {
    var flag;
    var link = new ListNode(0);
    if(head === null || head.next === null){
        return head;
    }
    link.next = head;
    flag = link;
    while(link.next !== null && link.next.next !== null){
        let first = link.next;
        let second = link.next.next;
        first.next = second.next;
        second.next = first;
        link.next = second;
        link = link.next.next;       
    }
    return flag.next;
};