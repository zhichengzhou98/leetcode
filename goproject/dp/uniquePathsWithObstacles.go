package main

import (
	"goproject/utils"
)

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	dp := make([][]int, len(obstacleGrid))
	for i := range dp {
		dp[i] = make([]int, len(obstacleGrid[i]))
	}
	if obstacleGrid[0][0] == 1 {
		return 0
	}
	dp[0][0] = 1
	//第0行
	for i := 1; i < len(obstacleGrid[0]); i++ {
		if obstacleGrid[0][i] == 1 {
			dp[0][i] = 0
		} else {
			dp[0][i] = utils.Min(1, dp[0][i-1])
		}
	}
	//第0列
	for i := 1; i < len(obstacleGrid); i++ {
		if obstacleGrid[i][0] == 1 {
			dp[i][0] = 0
		} else {
			dp[i][0] = utils.Min(1, dp[i-1][0])
		}
	}
	for i := 0; i < len(obstacleGrid); i++ {
		for j := 0; j < len(obstacleGrid[i]); j++ {
			if i != 0 && j != 0 {
				if obstacleGrid[i][j] == 1 {
					dp[i][j] = 0
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1]
				}
			}
		}
	}
	return dp[len(obstacleGrid)-1][len(obstacleGrid[0])-1]
}
