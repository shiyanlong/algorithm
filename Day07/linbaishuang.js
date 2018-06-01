var addTwoNumbers = function(l1, l2) {
    var list = new ListNode(-1),
        current = list;
    var flag = 0;
    var result = 0;
    while(l1 !== null || l2 !== null){
        var num1 = l1 === null ? 0 : l1.val;
        var num2 = l2 === null ? 0 : l2.val;
        result = num1 + num2 + flag;
        flag = result > 9 ? 1 : 0;
        result = parseInt(result % 10);
        current.next = new ListNode(result);  
        current = current.next;
        l1 = l1 ? l1.next : l1;
        l2 = l2 ? l2.next : l2;
    }
    if(flag === 1){
        current.next = new ListNode(1);
    }
    return list.next;
};