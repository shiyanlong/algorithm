package Day27


type TreeNode struct {
	Val int
	Left *TreeNode
 	Right *TreeNode
}

func pathSum(root *TreeNode, sum int) [][]int {
	if root == nil {
		return nil
	}
	return path(root,0, sum, nil, nil)
}

func path(tn *TreeNode, total int, sum int, p []int,r [][]int) [][]int {
	total += tn.Val
	p = append(p, tn.Val)
	if tn.Right == nil && tn.Left == nil {
		if sum == total {
			t := make([]int, len(p))
			copy(t,p)
			return append(r, t)
		}
		return r
	}

	if tn.Left != nil {
		 r = path(tn.Left, total, sum, p, r)
	}
	if tn.Right != nil {
		r = path(tn.Right, total, sum, p, r)
	}
	return r
}

func main() {
	
}
