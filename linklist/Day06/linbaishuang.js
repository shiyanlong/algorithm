const List = function () {
    var head = null;
    var Node = function(val) {      //创建节点
        this.val = val;
        this.next = null;
    };
    this.append = function (ele) {      //向链表添加元素
        var node = new Node(ele),current;
        if(head === null){
            head = node;
        } else {
            current = head;
            while (current.next){
                current = current.next;
            }
            current.next = node;
        }
        length++;
    };
    this.getList = function () {    //将链表输出
        var current = head;
        var str = '';
        while(current){
            str += current.val + ',';
            current = current.next;
        }
        return str;
    };
    this.first = function () {
        return head;
    };
    this.resetHead = function (newHead) {
        head = newHead;
    };
    this.insert = function (ele) {
        var node = new Node(ele);
        return node;
    };
};
function merge(list1, list2) {
    var listHead1 = list1.first();
    var listHead2 = list2.first();
    var pre = listHead1;
    if(listHead1.val > listHead2.val){
        var node = list1.insert(listHead2.val);
        node.next = listHead1;
        list1.resetHead(node);
        listHead1 = pre = node;
        listHead2 = listHead2.next;
    }
    while (listHead1 && listHead2){
        if(listHead1.val > listHead2.val){
            var node = list1.insert(listHead2.val);
            node.next = pre.next;
            pre.next = node;
            pre = node;
            listHead2 = listHead2.next;
        } else {
            pre = listHead1;
            listHead1 = listHead1.next;
        }
    }
    while (listHead2){
        var node = new List(listHead2.val);
        if(pre){
            pre.next = node;
            pre = node;
        }
        listHead2 = listHead2.next;
    }
    return list1.getList();
}
const CreatList = function () {
    var list1 = new List();
    var list2 = new List();
    list1.append(3);
    list1.append(4);
    list1.append(6);
    list2.append(2);
    list2.append(4);
    list2.append(5);
    var str = list1.getList();
    var str1 = list2.getList();
    var a = merge(list1, list2);
    console.log(a);
};
module.exports = CreatList;
2、
const removeSame = function () {
    var head = null;
    var Node = function (val) {
        this.val = val;
        this.next = null;
    };
    this.append = function (val) {
        var node = new Node(val),current;
        if(head === null){
            head = node;
        } else {
            current = head;
            while (current.next){
                current = current.next;
            }
            current.next = node;
        }
    };
    this.getList = function () {
        var str = '';
        var current = head;
        while (current){
            str += current.val + ',';
            current = current.next;
        }
        return str;
    };
    this.removesame = function () {
          var current = head;
          var pre;
          while (current){
              if(current.next && (current.val === current.next.val)){
                  pre = current.next;
                  current.next = pre.next;
              }
              current = current.next;
          }
    };
};
const remove = function () {
    var list = new removeSame;
    list.append(2);
    list.append(2);
    list.append(3);
    list.append(5);
    var a = list.getList();
    console.log(a);
    list.removesame();
    var b = list.getList();
    console.log(b);
};

module.exports = remove;