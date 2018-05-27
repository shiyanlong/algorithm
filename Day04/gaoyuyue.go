package main

import (
	"sort"
	"fmt"
)

func tuple3(a []int) [][]int {
	nm := map[string]bool{}
	n := len(a)
	sort.Ints(a)
	var r [][]int
	for i:=0; i<n; i++ {
		for j:=i+1; j<n; j++ {
			start := j+1
			end := n-1
			for start <= end {
				middle := (start + end) / 2
				sum := a[i] + a[j] + a[middle]
				if sum == 0 {
					len := len(nm)
					row := []int{a[i],a[j],a[middle]}
					sort.Ints(row)
					key := fmt.Sprint(row)
					if len == 0 || !nm[key]{
						r = append(r, row)
						nm[key] = true
					}
					break
				} else if sum > 0 {
					end -= 1
				} else {
					start += 1
				}
			}
		}
	}
	return r
}

func main() {
	a := []int{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}
	fmt.Println(tuple3(a))
}
