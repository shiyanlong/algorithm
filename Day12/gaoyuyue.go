package main

import "fmt"

func letterCasePermutation(S string) []string {
	var ss []string
	return swap(ss,S,0)
}

func swap(ss []string, S string, i int) []string {
	if i >= len(S) {
		return append(ss, S)
	}

	if S[i] >= 'a' && S[i] <= 'z' {
		ss = swap(ss,toUpperWithIndex(S,i),i+1)
	}
	if S[i] >= 'A' && S[i] <= 'Z' {
		ss = swap(ss,toLowerWithIndex(S,i),i+1)
	}

	ss = swap(ss,S,i+1)
	return ss
}



func toLowerWithIndex(s string,i int) string {
	n := len(s)
	bs := make([]byte, n)
	for j:=0; j<n; j++ {
		bs[j] = s[j]
		if j == i {
			bs[j] += ('a' - 'A')
		}
	}
	return string(bs)
}

func toUpperWithIndex(s string,i int) string {
	n := len(s)
	bs := make([]byte, n)
	for j:=0; j<n; j++ {
		bs[j] = s[j]
		if j == i {
			bs[j] -= ('a' - 'A')
		}
	}
	return string(bs)
}

func main() {
	permutation := letterCasePermutation("a1b2")
	fmt.Println(permutation)
	//s := "ab"
	//bytes := make([]byte, 2)
	//for i:=0; i<2; i++ {
	//	bytes[i] = s[i] - ('a' - 'A')
	//}
	//fmt.Println(utf8.RuneSelf)
	//fmt.Println(string(bytes))
}
