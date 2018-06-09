package main

import "fmt"

/**
两数组相乘返回结果数组
 */
func arraymul(a []int, b []int) []int {
	m,n := len(a),len(b)
	if m > n {
		a,b = b,a
		m,n = n,m
	}
	c := make([]int,m+n)
	for i:=m-1; i>=0; i-- {
		for j:=n-1; j>=0; j-- {
			c[i+j+1] += a[i] * b[j]
			if c[i+j+1] > 9 {
				c[i+j] += c[i+j+1] / 10
				c[i+j+1] %= 10
			}
		}
	}
	var index int
	for i:=0; i<m+n-1; i++ {
		if c[i] != 0 {
			index = i
			break
		}
	}
	r := make([]int, m+n-index)
	copy(r,c[index:])
	return r
}

func main() {
	a := []int{1,2,3}
	b := []int{2,1}
	fmt.Println(arraymul(a,b))
}
