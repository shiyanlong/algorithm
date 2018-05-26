package main

import (
	"sort"
	"container/list"
	"fmt"
)

func tuple3(a []int) [][]int {
	l := list.New()
	n := len(a)
	sort.Ints(a)
	var r [][]int
	for i,j:=0,n-1; i < j;{
		var k int
		for k=i+1; k<j; k++ {
			if a[i] + a[j] + a[k] == 0 {
				len := l.Len()
				if len == 0 {
					row := []int{a[i],a[j],a[k]}
					r = append(r, row)
					nm := map[int]bool{
						i: true,
						j: true,
						k: true,
					}
					l.PushBack(nm)
				} else {
					for e,h:= l.Front(),0; h<len; e,h = e.Next(),h+1 {
						v := e.Value.(map[int]bool)
						if !v[a[i]] || !v[a[j]] || !v[a[k]] {
							row := []int{a[i],a[j],a[k]}
							r = append(r, row)
							nm := map[int]bool{
								i: true,
								j: true,
								k: true,
							}
							l.PushBack(nm)
						}
					}
				}
				break
			}
		}
		if a[i] + a[j] + a[k-1] <= 0  {
			i++
		} else {
			j--
		}
	}
	return r
}

func main() {
	a := []int{-1, 0, 1, 2, -1, -4}
	fmt.Println(tuple3(a))
}
