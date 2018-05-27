package main

import (
	"container/list"
	"math"
	"fmt"
)

type tuple struct {
	First int
	Second int
}

func minPathSum(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	return op2(grid,m,n)
}

func op2(a [][]int, m,n int) int{
	for i:=1; i< m; i++ {
		a[i][0] += a[i-1][0]
	}
	for i:=1; i< n; i++ {
		a[0][i] += a[0][i-1]
	}
	for i:=1; i<m; i++ {
		for j:=1; j<n; j++ {
			if a[i-1][j] < a[i][j-1] {
				a[i][j] += a[i-1][j]
			} else {
				a[i][j] += a[i][j-1]
			}
		}
	}
	return a[m-1][n-1]
}

func op(a [][]int, m,n int) int {
	i,j,sum,min := 0,0,0,math.MaxInt32
	l := list.New()
	l.PushBack(tuple{0,0})
	for l.Len() != 0 {
		if i != m && j != n {
			l.PushBack(tuple{i+1,j})
			l.PushBack(tuple{i,j+1})
			sum += a[i][j]
			j += 1
		} else if i != m && j == n {
			l.PushBack(tuple{i+1,j})
			sum += a[i][j]
			i += 1
		} else if i == m && j != n {
			l.PushBack(tuple{i,j+1})
			sum += a[i][j]
			j += 1
		} else {
			sum += a[i][j]
			var f,s tuple
			if sum < min {
				min = sum
			}
			for {
				f = l.Remove(l.Back()).(tuple)
				sum -= a[f.First][f.Second]
				if l.Len() == 0 {
					break
				}
				s = l.Back().Value.(tuple)
				if s.First - 1 == f.First && s.Second + 1 == f.Second {
					i,j = s.First,s.Second
					break
				}
			}
		}
	}
	return min
}

func main() {
	//[[1,2],[1,1]]
	a := [][]int{{1,2}, {1,1}}
	//str := fmt.Sprint(a)
	//fmt.Println(str)
	fmt.Println(minPathSum(a))
}
