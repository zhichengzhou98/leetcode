package main

import (
	"fmt"
	"goproject/utils"
)

func main() {
	//max := [][]byte{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1',
	//'1'}, {'1', '0', '0', '1', '0'}}
	max := [][]byte{{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1', '0', '1', '1'}, {'1', '1', '1', '1'}}
	fmt.Println(maximalSquare(max))
}

// 221
func maximalSquare(matrix [][]byte) int {

	dp := make([][]int, len(matrix))
	for i := range dp {
		dp[i] = make([]int, len(matrix[i]))
	}
	//dp[i][j]: 以i,j为右下角的正方形
	res := 0

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[i]); j++ {
			temp := formatByte(matrix[i][j])
			if i == 0 {
				//第0行
				dp[i][j] = temp
				res = utils.Max(res, dp[i][j])
				continue
			}
			if j == 0 {
				//第0列
				dp[i][j] = temp
				res = utils.Max(res, dp[i][j])
				continue
			}
			if temp == 0 {
				dp[i][j] = 0
			} else {
				dp[i][j] = utils.Min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
			}
			res = utils.Max(res, dp[i][j])
		}
	}
	return res * res
}

func formatByte(a byte) int {
	if a == '1' {
		return 1
	}
	return 0
}
