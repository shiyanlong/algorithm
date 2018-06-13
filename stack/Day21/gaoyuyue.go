package main

import "container/list"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func postorderTraversal(root *TreeNode) []int {
	stack := list.New()
	var result []int
	if root != nil {
		stack.PushBack(root)
	}
	var t *TreeNode
	for stack.Len() != 0 {
		t = stack.Back().Value.(*TreeNode)
		if t.Right != root && t.Left != root {
			for ; t != nil; t = stack.Back().Value.(*TreeNode) {
				if t.Left != nil {
					if t.Right != nil {
						stack.PushBack(t.Right)
					}
					stack.PushBack(t.Left)
				} else {
					stack.PushBack(t.Right)
				}
			}
			stack.Remove(stack.Back())
		}
		root = stack.Remove(stack.Back()).(*TreeNode)
		result = append(result, root.Val)
	}
	return result
}

func main() {
	
}
