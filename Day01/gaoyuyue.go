package main

import (
	"fmt"
)

/**
给定一个数组，删除某个特定的位置。
 */
func q1(a []int,i int) []int {
	n := len(a)
	for j:=i; j<n; j++ {
		a[j-1] = a[j]
	}
	m := make([]int, n-1)
	copy(m,a[:n-1])
	return m
}

/**
给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 */
func q2(a []int) []int {
	b := false
	n := len(a)
	a[n-1] += 1
	for i:=n-1; i >= 0; i-- {
		if b {
			a[i] = a[i] + 1
			b = false
		}
		if a[i] > 9 {
			a[i] = 0
			b = true
		}
	}
	if b {
		m := make([]int,n+1)
		m[0] = 1
		copy(m[1:],a)
		a = m
	}
	return a
}

/**
给定两个非空数组，对这两个数组相加。
 */
func q3(a []int,b []int) []int {
	t := false
	m,n := len(a),len(b)
	if m < n {
		a,b = b,a
		m,n = n,m
	}
	for i, j := m-1, n-1; i >= 0 && j >= 0; i, j = i-1, j-1 {
		if t {
			a[i] += 1
			t = false
		}
		if a[i] += b[j]; a[i] > 9 {
			a[i] %= 10
			t = true
		}
	}

	if t {
		r := make([]int,m+1)
		r[0] = 1
		copy(r[1:],a)
		a = r
	}
	return a
}

func main() {
	a := []int{1,2,3,4,5,6,9}
	b := []int{1,1,1,1}
	fmt.Println(q1(a,2))
	fmt.Println(q2(a))
	fmt.Println(q3(a,b))
}
