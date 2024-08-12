package main

import (
	"goproject/utils"
)

func main() {

}

// 931
// 原地修改数组
func minFallingPathSum(matrix [][]int) int {
	n := len(matrix)
	for i := 1; i < n; i++ {
		for j := 0; j < n; j++ {
			temp := matrix[i][j]
			matrix[i][j] = matrix[i-1][j]
			if j >= 1 {
				matrix[i][j] = utils.Min(matrix[i][j], matrix[i-1][j-1])
			}
			if j+1 < n {
				matrix[i][j] = utils.Min(matrix[i][j], matrix[i-1][j+1])
			}
			matrix[i][j] += temp
		}
	}
	return utils.ArrayMin(matrix[n-1])
}

func minFallingPathSumV1(matrix [][]int) int {
	n := len(matrix)
	dp := make([][]int, n)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	//第0行
	for i := 0; i < n; i++ {
		dp[0][i] = matrix[0][i]
	}
	for i := 1; i < n; i++ {
		for j := 0; j < n; j++ {
			dp[i][j] = dp[i-1][j]
			if j >= 1 {
				dp[i][j] = utils.Min(dp[i][j], dp[i-1][j-1])
			}
			if j+1 < n {
				dp[i][j] = utils.Min(dp[i][j], dp[i-1][j+1])
			}
			dp[i][j] += matrix[i][j]
		}

	}
	return utils.ArrayMin(dp[n-1])
}
