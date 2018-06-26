package main

import (
	"math"
	"container/list"
)

func find132pattern(nums []int) bool {
	k:=math.MinInt32
	s := list.New()
	for i := len(nums)-1; i>=0; i--{
		if nums[i] < k {
			return true
		} else {
			for s.Len() != 0 && nums[i] > s.Back().Value.(int) {
				k = s.Remove(s.Back()).(int)
			}
		}
		s.PushBack(nums[i])
	}
	return false
}

func main() {
	
}
