var partition = function(head, x) {
    var current = head;
    var pre = head;
    var index = null;
    while(current){
        if(head === null && current.next === null){
            return head;
        } else if(current.val < x){
            if(current === head){
                current = current.next; 
            }else if(current !== head && pre.next !== current){
                index.next = current.next;
                pre.next = current;
                current = current.next = pre.next;
                pre = current;
            }else if(index === head && current.next === null){
                current.next = head;
                current = head.next = null;
            } else if(index !== head && pre.next === current && current.next === null ){
                return head;
            }
        } else {
            index = current; 
            current = current.next;
        }
        
    }
    return head;
};