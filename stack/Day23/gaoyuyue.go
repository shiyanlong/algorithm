package main

import (
	"container/list"
	"strconv"
	"fmt"
)

type TreeNode struct {
	Val int
    Left *TreeNode
    Right *TreeNode
}

func zigzagLevelOrder(root *TreeNode) [][]int {
	ls,rs := list.New(),list.New()
	if root != nil{
		ls.PushBack(root)
	}
	var result [][]int
	var t *TreeNode
	for ls.Len() != 0 || rs.Len() != 0 {
		var l []int
		for ls.Len() != 0 {
			t = ls.Remove(ls.Back()).(*TreeNode)
			l = append(l,t.Val)
			if t.Left != nil {
				rs.PushBack(t.Left)
			}
			if t.Right != nil {
				rs.PushBack(t.Right)
			}
		}
		if len(l) > 0 {
			result = append(result,l)
		}
		var r []int
		for rs.Len() != 0 {
			t = rs.Remove(rs.Back()).(*TreeNode)
			r = append(r,t.Val)
			if t.Right != nil {
				ls.PushBack(t.Right)
			}
			if t.Left != nil {
				ls.PushBack(t.Left)
			}
		}
		if len(r) > 0 {
			result = append(result,r)
		}
	}
	return result
}

func decodeString(s string) string {
	var result string
	cs := list.New()
	ns := list.New()

	cs.PushBack(result)
	i:=0
	var j,num int
	for i<len(s) {
		if (s[i] < '0' || s[i] > '9') && s[i] != ']'{
			cs.Back().Value = cs.Back().Value.(string) + string(s[i])
		}
		j = 0
		for s[i] >= '0' && s[i] <= '9'  {
			i++
			j++
		}
		if s[i] == '[' {
			num, _ := strconv.Atoi(s[i-j : i])
			ns.PushBack(num)
			cs.PushBack("")
		}
		if s[i] == ']' {
			num = ns.Remove(ns.Back()).(int)
			var m string
			r := cs.Remove(cs.Back()).(string)
			for k:=0; k<num; k++ {
				m += r
			}
			if cs.Len() == 0 {
				result += m
			} else {
				cs.Back().Value = cs.Back().Value.(string) + m
			}
		}
		i++
	}
	result += cs.Remove(cs.Back()).(string)
	return result
}

func decode(s string,i int) (string,int) {
	var r string
	for i < len(s) && s[i] != ']' {
		j := 0
		if s[i] < '0' || s[i] > '9' {
			r += string(s[i])
			i++
		}
		if i >= len(s) {
			return r,i
		}
		for s[i] >= '0' && s[i] <= '9'  {
			i++
			j++
		}
		if s[i] == '[' {
			num, _ := strconv.Atoi(s[i-j : i])
			i++
			ts, ti := decode(s, i)
			for k:=0; k<num; k++ {
				r += ts
			}
			if ti >= len(s){
				return r,ti
			}
			i = ti
		}
	}
	return r,i+1
}

func main() {
	s := decodeString("2[abc]3[cd]ef")
	fmt.Println(s)
}
