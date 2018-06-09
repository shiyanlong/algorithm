package main

import (
	"strconv"
	"fmt"
)

func restoreIpAddresses(s string) []string {
	if len(s) < 4 {
		return nil
	}
	nums := make([]string,4)
	return restore(0,3,0,s,nums,nil)
}

func restore(start,m,deep int, s string, nums,r []string) []string {
	if deep >= 4 {
		ss := make([]string,4)
		copy(ss,nums)
		return append(r,ss[0]+"."+ss[1]+"."+ss[2]+"."+ss[3])
	}
	for j:=1; j<=m; j++ {
		end := start + j
		if end>len(s) || deep == 3 && end != len(s) {
			continue
		}
		if s[start] == '0' && j > 1 {
			continue
		}
 		num := s[start:end]

		n, _ := strconv.Atoi(num)
		if n>=0 && n<=255 {
			nums[deep] = num
			r = restore(end,m,deep+1,s,nums,r)
		}
	}
	return r
}

func main() {
	addresses := restoreIpAddresses("00000")
	fmt.Println(addresses)
}
