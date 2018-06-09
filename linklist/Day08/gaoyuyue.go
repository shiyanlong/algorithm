package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return nil
	}
	t := head
	n := 1
	for ; t.Next != nil; t = t.Next {
		n++
	}
	t.Next = head
	var i int
	if n >= k {
		i = n-k
	} else {
		i = n - (k % n)
	}

	for ; i>0; i-- {
		t = t.Next
	}

	head,t.Next = t.Next,nil
	return head
}

func main() {
	node1 := &ListNode{1, nil}
	node1.Next = &ListNode{2, nil}
	node1.Next.Next = &ListNode{4, nil}
	right := rotateRight(node1, 4)
	fmt.Println(right)
}
