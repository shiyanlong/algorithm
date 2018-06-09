package main

import (
	"container/list"
	"fmt"
	"strconv"
)

func evalRPN(tokens []string) int {
	stack := list.New()
	var t1,t2 int
	for i:=0; i<len(tokens); i++ {
		switch tokens[i] {
		case "+":
			t1 = stack.Remove(stack.Back()).(int)
		    t2 = stack.Remove(stack.Back()).(int)
		    stack.PushBack(t2+t1)
		case "-":
			t1 = stack.Remove(stack.Back()).(int)
			t2 = stack.Remove(stack.Back()).(int)
			stack.PushBack(t2-t1)
		case "*":
			t1 = stack.Remove(stack.Back()).(int)
			t2 = stack.Remove(stack.Back()).(int)
			stack.PushBack(t2*t1)
		case "/":
			t1 = stack.Remove(stack.Back()).(int)
			t2 = stack.Remove(stack.Back()).(int)
			stack.PushBack(t2/t1)
		default:
			num, _ := strconv.Atoi(tokens[i])
			stack.PushBack(num)
		}
	}

	return stack.Remove(stack.Back()).(int)
}

func main() {
	ss := []string{
		"2","1","+","3","*",
	}
	rpn := evalRPN(ss)
	fmt.Println(rpn)
}
