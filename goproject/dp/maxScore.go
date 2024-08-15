package main

import (
	"goproject/utils"
	"math"
)

func main() {

}

// 3148. 矩阵中的最大得分
func maxScore(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	//dp[i][j] 表示在以 i,j的矩形中，且不包括该点的最小值
	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	res := math.MinInt64
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 && j == 0 {
				//0, 0 初始为最大值
				dp[i][j] = math.MaxInt64
			} else if i == 0 {
				//第一行
				dp[i][j] = utils.Min(dp[i][j-1], grid[i][j-1])
			} else if j == 0 {
				//第一列
				dp[i][j] = utils.Min(dp[i-1][j], grid[i-1][j])
			} else {
				dp[i][j] = utils.Min(dp[i-1][j], grid[i-1][j], dp[i][j-1], grid[i][j-1])
			}
			res = utils.Max(res, grid[i][j]-dp[i][j])
		}
	}
	return res
}
