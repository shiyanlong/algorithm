package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func sortedListToBST(head *ListNode) *TreeNode {
	n := 0
	for t:=head; t != nil; t = t.Next {
		n++
	}
	return binSearch(head,n)
}

func binSearch(node *ListNode, n int) (tn *TreeNode) {
	if n == 0 {
		return nil
	}
	t := node
	for i:=0; i<n/2; i++ {
		t = t.Next
	}
	tn = &TreeNode{t.Val,nil,nil}
	tn.Left = binSearch(node,n/2)
	tn.Right = binSearch(t.Next,n-n/2-1)
	return
}

func main() {
	node1 := &ListNode{-10, nil}
	node1.Next = &ListNode{-3, nil}
	node1.Next.Next = &ListNode{0, nil}
	node1.Next.Next.Next = &ListNode{5, nil}
	node1.Next.Next.Next.Next = &ListNode{9, nil}
	treeNode := sortedListToBST(node1)
	fmt.Println(treeNode)
}
