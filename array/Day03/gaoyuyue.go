package main

import "fmt"

/**
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 */
func moveK(a []int, k int) []int {
	l := len(a)
	m,n := k,0
	p := a[0]
	var q int
	for i:=0; i<l; i++ {
		q = a[m]
		a[m] = p
		p = q
		if m == n {
			m = n+1
			n = m
		} else {
			m += k
			if m >= l {
				m %= l
			}
		}
	}
	return a
}

/**
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 */
func removeZero(a []int) []int {
	n := len(a)
	j := 0
	for i:=0; i<n; i++ {
		if a[i] != 0 {
			a[j] = a[i]
			if i > j {
				a[i] = 0
			}
			j++
		}
	}
	return a
}

func main() {
	a := []int{0,2,3,0,5,6,7}
	fmt.Println(moveK(a,3))
	fmt.Println(removeZero(a))
}
