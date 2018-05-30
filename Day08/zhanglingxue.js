/*给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL*/
var ListNode =function(val){
    this.val=val; //指向该节点
    this.next=null; //指向下一个节点
};
var l1 = new ListNode (0);
var t2 = new ListNode (1);
var t3 = new ListNode (2);
l1.next = t2;
t2.next = t3;
var k = 4;
function List(l1,k) {
    if (k === 0 || l1 === null)
        return l1;
    var prev = l1;
    var len = 0;
    while(prev.next !== null){
        prev =prev.next;
        len ++;
    }
    len ++;
    k = k % len;
    prev.next = l1;
    while(len - k > 0){ //向右挪i位相当于向左挪长度减i位
        l1 = l1.next;
        prev = prev.next;
        k ++;
    }
    prev.next = null;
    return l1;
}
console.log(List(l1,k));