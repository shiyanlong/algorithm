package main

import (
	"container/list"
	"fmt"
)

func isValid(s string) bool {
	stack := list.New()
	var i int
	for i=0; i< len(s); i++  {
		b := s[i]
		if b == '(' || b == '{' || b == '[' {
			stack.PushBack(b)
		}
		if b == ')' || b == '}' || b == ']' {
			if stack.Len() <= 0 {
				 return false
			}
			t := stack.Remove(stack.Back()).(byte)
			if !(t == '(' && b == ')' || t == '{' && b == '}' || t == '[' && b == ']') {
				return false
			}
		}
	}
	if stack.Len() == 0 && i == len(s) {
		return true
	}
	return false
}

func main() {
	valid := isValid("([)]")
	fmt.Println(valid)
}
