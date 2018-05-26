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
	return op(grid,m-1,n-1)
}

func op(a [][]int, m,n int) int {
	i,j,sum,min := 0,0,0,math.MaxInt32
	l := list.New()
	l.PushBack(tuple{0,0})
	for l.Len() != 0 {
		if i != m && j != n {
			l.PushBack(tuple{i,j+1})
			l.PushBack(tuple{i+1,j})
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
				if s.First + 1 != f.First && s.Second + 1 != f.Second {
					l.Remove(l.Back())
					i,j = s.First,s.Second
					break
				}
			}
		}
	}
	return min
}

func main() {
	a := [][]int{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}
	fmt.Println(minPathSum(a))
}
