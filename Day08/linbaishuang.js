 var index = k;
    var current = head;
    var pre;
    var len = 1;
    var a = 1;
    if(head === null || k === 0){
        return head;
    }
    while(current.next){
        len ++;        
        current = current.next;
    }
    current.next = head;
    n = parseInt(k / len);
    console.log(n)
    if(n > 0){
        k = k - n * len;
        console.log(k);
    }
    index = len-k+1;
    console.log(index);
    while(current.next){
        if(a === index){
            pre = current.next;
            current.next = null;
            return pre;
        }
        current = current.next;
        a++;
    }