package main

import "goproject/utils"

func main() {

}

// 516. 最长回文子序列
func longestPalindromeSubseq(s string) int {
	size := len(s)
	dp := make([][]int, size)
	for i := range dp {
		dp[i] = make([]int, size)
	}
	//dp[i][j]表示i,j之间最长的回文子序列
	//需要保证：更新dp[i][j]时 dp[i + 1][j - 1]，dp[i + 1][j]， dp[i][j - 1]都已经更新
	//dp[i][j] = dp[i + 1][j - 1] + 2;
	//dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
	//因此能按字符串长度进行遍历 -> [i][j]之间的长度比[i + 1][j - 1] [i + 1][j] [i][j - 1]长
	for i := 0; i < size; i++ {
		//i表示字符串长度
		for j := 0; j+i < size; j++ {
			//j表示起始字符串的位置
			if i == 0 {
				dp[j][j+i] = 1
			} else {
				left := s[j]
				right := s[j+i]
				if left == right {
					dp[j][j+i] = dp[j+1][j+i-1] + 2
				} else {
					dp[j][j+i] = utils.Max(dp[j+1][j+i], dp[j][j+i-1])
				}
			}
		}
	}
	return dp[0][size-1]
}
