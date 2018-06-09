package main

import (
	"container/list"
)

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	stack := list.New()
	var r []int
	for {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}
		if stack.Len() == 0 {
			break
		}
		root = stack.Remove(stack.Back()).(*TreeNode)
		r = append(r, root.Val)
		root = root.Right
	}
	return r
}

func main() {
	
}
