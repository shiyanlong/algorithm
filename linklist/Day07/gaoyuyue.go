package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := new(ListNode)
	t := head
	b := false
	for ;l1 != nil; l1,l2 = l1.Next,l2.Next {
		if l2 == nil {
			break
		}
		l1.Val += l2.Val
		if b {
			l1.Val += 1
			b = false
		}
		if l1.Val > 9 {
			l1.Val %= 10
			b = true
		}
		t.Next = l1
		t = t.Next
	}
	if l1 == nil {
		if b {
			for ; l2 != nil; l2 = l2.Next {
				l2.Val += 1
				t.Next = l2
				if l2.Val <= 9 {
					break
				} else {
					l2.Val = 0
				}
				t =t.Next
			}
			if l2 == nil {
				t.Next = &ListNode{1,nil}
			}
		} else {
			t.Next = l2
		}
	} else if l2 == nil {
		if b {
			for ; l1 != nil; l1 = l1.Next {
				t.Next = l1
				l1.Val += 1
				if l1.Val <= 9 {
					break
				} else {
					l1.Val = 0
				}
				t = t.Next
			}
			if l1 == nil {
				t.Next = &ListNode{1,nil}
			}
		}
	}
	return head.Next
}

func main() {
	node1 := &ListNode{9, nil}
	node1.Next = &ListNode{9, nil}
	node2 := &ListNode{9, nil}
	lists := addTwoNumbers(node1, node2)
	fmt.Println(lists)
}
