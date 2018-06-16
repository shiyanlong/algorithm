package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	k,max := 0,1
	if len(s) == 0 {
		return 0
	}
	var i,j int
	for i=1; i<len(s); i++{
		for j=k; j < i; j++ {
			if s[j] == s[i] {
				if max < i - j {
					max = i - j
				}
				k = j + 1
				break
			}
		}
		if i == j {
			if max < i - k + 1{
				max = i - k + 1
			}
		}
	}

	return max
}

func main() {
	i := lengthOfLongestSubstring("cdd")
	fmt.Println(i)
}
