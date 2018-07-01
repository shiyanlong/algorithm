package main

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func addOneRow(root *TreeNode, v int, d int) *TreeNode {
	if d == 1 {
		return &TreeNode{v, root, nil}
	}
	add(root, v, d, 1)
	return root
}

func add(tn *TreeNode, v, d, i int)  {
	if tn == nil {
		return
	}
	if i == d - 1 {
		left := &TreeNode{v, tn.Left, nil}
		right := &TreeNode{v, nil, tn.Right}
		tn.Left = left
		tn.Right = right
		return
	}
	add(tn.Left, v, d, i+1)
	add(tn.Right, v, d, i+1)
}

func main() {
	
}
