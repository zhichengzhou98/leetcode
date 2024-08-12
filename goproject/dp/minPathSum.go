package main

import (
	"fmt"
	"goproject/utils"
)

func main() {
	grid := [][]int{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}
	fmt.Println(minPathSum(grid))
}

func minPathSum(grid [][]int) int {
	dp := make([][]int, len(grid))
	for i := range dp {
		dp[i] = make([]int, len(grid[0])) // 为每一行分配内存
	}
	dp[0][0] = grid[0][0]
	//第 0 行
	for i := 1; i < len(grid[0]); i++ {
		dp[0][i] = dp[0][i-1] + grid[0][i]
	}
	//第0列
	for i := 1; i < len(grid); i++ {
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if i != 0 && j != 0 {
				dp[i][j] = utils.Min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
			}
		}
	}
	return dp[len(grid)-1][len(grid[0])-1]
}
