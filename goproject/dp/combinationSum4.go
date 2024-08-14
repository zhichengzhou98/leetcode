package main

import "fmt"

// 377 顺序不同作为不同的结果
func main() {
	arr := []int{1, 2, 4}
	fmt.Println(combinationSum4(arr, 7))
}

func combinationSum4(nums []int, target int) int {
	size := len(nums)
	dp := make([]int, target+1)
	//dp[i]表示组成数字i的所有组合数
	//dp[0] = 1，所有数字都不选
	//遍历所有的nums
	//dp[i] = Σdp[i - nums[j]]
	dp[0] = 1
	for i := 1; i < len(dp); i++ {
		for j := 0; j < size; j++ {
			if i-nums[j] >= 0 {
				dp[i] += dp[i-nums[j]]
			}
		}
	}
	return dp[target]
}
