package main

type ListNode struct {
	Val int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	start := new(ListNode)
	start.Next = head
	f := start
	b := start.Next
	for f!=nil && b != nil && b.Next != nil {
		f.Next = b.Next
		f,b = b,b.Next
		f.Next = b.Next
		b.Next = f
		b = f.Next
	}
	return start.Next
}

func main() {
	node1 := &ListNode{1, nil}
	node1.Next = &ListNode{4, nil}
	node1.Next.Next = &ListNode{3, nil}
	node1.Next.Next.Next = &ListNode{2, nil}
	node1.Next.Next.Next.Next = &ListNode{5, nil}
	node1.Next.Next.Next.Next.Next = &ListNode{2, nil}
	swapPairs(node1)
}
