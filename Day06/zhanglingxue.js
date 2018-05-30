/*将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。*/
/*输入：1->2->4, 1->3->4->5
输出：1->1->2->3->4->4*/
var Node=function(val){
    this.val=val; //指向该节点
    this.next=null; //指向下一个节点
};
var l1 = new Node(1);
var t2 = new Node(2);
var t3 = new Node(4);

var l2 = new Node(1);
var t5 = new Node(3);
var t6 = new Node(4);
var t7 = new Node(6);
l1.next = t2;
t2.next = t3;

l2.next = t5;
t5.next = t6;
t6.next = t7;
function mergeTwoLists(l1, l2){
    while(l2){ //遍历l2
        var prev = null;
        var cur = l1;
        while(cur && l2.val > cur.val){
            prev = cur; //记录先前的l1元素
            cur = cur.next;
        }
        var newNode = new Node(l2.val); //插入新节点
        newNode.next = cur; //新节点的next指向当前的l1元素(此时的cur已是比较后的next值)
        if(prev) {  //先前的新节点的next值指向新节点
            prev.next = newNode;
        }else{ //先前链表无元素的情况
            l1 = newNode;
        }
        l2 = l2.next;
    }
    return l1;
}
console.log(mergeTwoLists(l1,l2));


/*输入: 1->2->4->4->5->6->6
输出: 1->4->5->6*/
function deleteDuplicates(l1) {
    var prev = l1;
    var cur = l1;
    var p = null;
    while(cur){
        p = cur.next;
        if(prev.val === cur.val) {
            prev.next = p;
            cur = p;
        }else {
            prev = cur;
            cur = p;
        }
    }
    return l1;
}
console.log(deleteDuplicates(l1));