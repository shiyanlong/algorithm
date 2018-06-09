package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {
	font := new(ListNode)
	back := new(ListNode)
	var f,b *ListNode
	f,b = font,back
	for head != nil {
		if head.Val < x {
			f.Next = head
			f = f.Next
			head = head.Next
			f.Next = nil
			fmt.Println(f)
		} else {
			b.Next = head
			b = b.Next
			head = head.Next
			b.Next = nil
		}
	}
	f.Next = back.Next
	return font.Next
}

func main() {
	node1 := &ListNode{1, nil}
	node1.Next = &ListNode{4, nil}
	node1.Next.Next = &ListNode{3, nil}
	node1.Next.Next.Next = &ListNode{2, nil}
	node1.Next.Next.Next.Next = &ListNode{5, nil}
	node1.Next.Next.Next.Next.Next = &ListNode{2, nil}
	node := partition(node1, 3)
	fmt.Println(node)
}
