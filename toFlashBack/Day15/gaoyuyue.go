package main

import "fmt"

func generateParenthesis(n int) []string {
	var i,j int
	var s string
	return dfs(i,j,n,s,nil)
}

func dfs(i,j,n int, s string, ss []string) []string {
	if i > n || j > i {
		return ss
	}

	if i == n && j == n {
		return append(ss,s)
	}

	ss = dfs(i+1,j,n,s+"(",ss)
	ss = dfs(i,j+1,n,s+")",ss)
	return ss
}

func main() {
	parenthesis := generateParenthesis(3)
	fmt.Println(parenthesis)
}
