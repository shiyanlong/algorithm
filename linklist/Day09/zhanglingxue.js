/*给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
输入: head = 1->4->3->2->5->2->null, x = 3
输出: 1->2->2->4->3->5->null*/
var ListNode =function(val){
    this.val=val; //指向该节点
    this.next=null; //指向下一个节点
};
var l1 = new ListNode (3);
var t2 = new ListNode (1);
var t3 = new ListNode (2);
var t4 = new ListNode (2);
var t5 = new ListNode (5);
var t6 = new ListNode (2);
l1.next = t2;
t2.next = t3;
t3.next = t4;
t4.next = t5;
t5.next = t6;
var x = 3;
function List(l1,x) {
    var prev = l1;
    var cur = l1;
    var node = null;
    while(prev){
        if(prev.val >= x){
            node = prev;
            break;
        }else{
            cur = prev;
            prev = prev.next;
        }
    }
    if(prev === null ||prev.next === null){
        return l1;
    }
    var p = prev.next;
    while(p){
        if(p.val >= x){
            prev = p;
            p = p.next;
        }else{
            var m = p;
            p = p.next;
            prev.next = p;
            m.next = node;
            if(cur === node){
                l1 = m;
                cur = m;
            }else{
                cur.next = m;
                cur = cur.next;
            }
        }
    }
    return l1;
}
console.log(List(l1,x));