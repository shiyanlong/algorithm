package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func sumNumbers(root *TreeNode) int {
	if root == nil {
		return 0
	}
	ints := sumNumber(root, 0, nil)
	sum := 0
	for i:=0; i<len(ints); i++ {
		sum += ints[i]
	}
	return sum
}

func sumNumber(tn *TreeNode, sum int, r []int) []int {
	sum = sum * 10 + tn.Val
	if tn.Right == nil && tn.Left == nil {
		return append(r, sum)
	}
	if tn.Left != nil {
		r = sumNumber(tn.Left, sum, r)
	}
	if tn.Right != nil {
		r = sumNumber(tn.Right, sum, r)
	}
	return r
}

func main() {
	node4 := &TreeNode{1,nil,nil}
	node3 := &TreeNode{1,nil,nil}
	node2 := &TreeNode{1,node4,nil}
	node1 := &TreeNode{1,node2,node3}
	numbers := sumNumbers(node1)
	fmt.Println(numbers)
}
