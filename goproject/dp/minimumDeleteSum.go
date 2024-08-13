package main

import (
	"fmt"
	"goproject/utils"
)

func main() {
	fmt.Println(int('e'))
	fmt.Println(int('l'))
	fmt.Println(minimumDeleteSum("delete", "leet"))
}

// 712
func minimumDeleteSum(s1 string, s2 string) int {
	size1 := len(s1) + 1
	size2 := len(s2) + 1
	dp := make([][]int, size1)
	for i := range dp {
		dp[i] = make([]int, size2)
	}
	//dp[i][j]表示子字符串s1[0, i]与s2[0,j]的最小删除和
	//char1 := s1[i]  char2 := s2[j]

	//i=0时，表示s1的子字符串为空串
	//j=0时，表示s2的子字符串为空串
	for i := 0; i < size1; i++ {
		for j := 0; j < size2; j++ {
			if i == 0 && j >= 1 {
				dp[i][j] = int(s2[j-1]) + dp[i][j-1]
				continue
			}
			if j == 0 && i >= 1 {
				dp[i][j] = int(s1[i-1]) + dp[i-1][j]
				continue
			}
			if j == 0 && i == 0 {
				continue
			}
			char1 := s1[i-1]
			char2 := s2[j-1]
			if char1 == char2 {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = utils.Min(dp[i][j-1]+int(char2), dp[i-1][j]+int(char1))
			}
		}
	}
	return dp[size1-1][size2-1]
}
