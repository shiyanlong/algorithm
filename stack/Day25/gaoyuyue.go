package main

import (
	"container/list"
)

func removeKdigits(num string, k int) string {
	stack := list.New()
	for i:=0; i<len(num); i++{
		for k > 0 && stack.Len() > 0 && stack.Back().Value.(byte) > num[i] {
			stack.Remove(stack.Back())
			k--
		}
		stack.PushBack(num[i])
	}
	for i:=0; i < k; i++ {
		stack.Remove(stack.Back())
	}
	b := false
	var r string
	for e:=stack.Front(); e != nil ; e = e.Next() {
		if !b && e.Value.(byte) != '0' {
			b = true
		}
		if b {
			r += string(e.Value.(byte))
		}
	}
	if len(r) == 0 {
		r = "0"
	}
	return r
}

func main() {
	
}
