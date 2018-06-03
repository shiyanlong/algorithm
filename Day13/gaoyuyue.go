package main

import "fmt"

func combine(n int, k int) [][]int {
	var rs [][]int
	r := make([]int, k)
	return pull(r,0,k,n,0,rs)
}

func pull(r []int, i,k,n,index int, rs [][]int) [][]int {
	if index >= k {
		m := make([]int, k)
		copy(m,r)
		return append(rs,m)
	}
	for j:=i; j<n; j++ {
		r[index] = j+1
		rs = pull(r,j+1,k,n,index+1,rs)
	}
	return rs
}

func main() {
	ints := combine(4, 2)
	fmt.Println(ints)
}
