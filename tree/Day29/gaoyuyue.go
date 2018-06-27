package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	return depth(root, 0)
}

func depth(tn *TreeNode, deep int) int {
	if tn == nil {
		return deep
	}
	l := depth(tn.Left, deep+1)
	r := depth(tn.Right, deep+1)
	if l > r {
		return l
	}
	return r
}

func isSameTree(p *TreeNode, q *TreeNode) bool {
	return same(p,q)
}

func same(p * TreeNode, q * TreeNode) bool {
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil || p.Val != q.Val || !same(p.Left,q.Left) || !same(p.Right,q.Right) {
		return false
	}
	return true
}

func main() {
	
}
