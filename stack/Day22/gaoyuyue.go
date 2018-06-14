package main

import (
	"strings"
	"container/list"
	"fmt"
)

func simplifyPath(path string) string {
	var result string
	ss := strings.Split(path, "/")
	stack := list.New()
	for i:=0; i<len(ss); i++ {
		if ss[i] == "" || ss[i] == "." {
			continue
		} else if ss[i] == ".." {
			if stack.Len() == 0{
				continue
			} else {
				stack.Remove(stack.Back())
			}
		} else {
			stack.PushBack(ss[i])
		}
	}
	if stack.Len() == 0 {
		return "/"
	}
	for t:=stack.Front(); t != nil; t = t.Next() {
		result += "/"+t.Value.(	string)
	}

	return result
}

func main() {
	path := simplifyPath("/..")
	fmt.Println(path)
}
