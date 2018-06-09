package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	h := new(ListNode)
	t := h
	for l1 != nil {
		if l2 == nil {
			break
		}
		if l1.Val <= l2.Val {
			t.Next = l1
			l1 = l1.Next
		} else {
			t.Next = l2
			l2 = l2.Next
		}
		t = t.Next
	}
	if l1 == nil {
		t.Next = l2
	} else {
		t.Next = l1
	}
	return h.Next
}

func deleteDuplicates(head *ListNode) *ListNode {
	start := new(ListNode)
	s := start
	t := head
	for ;t != nil; t = t.Next {
		if t.Next != nil && t.Val == t.Next.Val{
			continue
		}
		s.Next = t
		s = s.Next
	}
	return start.Next
}

func main() {
	node1 := &ListNode{1, nil}
	node1.Next = &ListNode{2, nil}
	node1.Next.Next = &ListNode{4, nil}
	node2 := &ListNode{1, nil}
	node2.Next = &ListNode{2, nil}
	node2.Next.Next = &ListNode{4, nil}
	lists := mergeTwoLists(node1, node2)
	fmt.Println(lists)
}
