package main

import "fmt"

func main() {
	coins := []int{1, 2, 5}
	fmt.Println(change(5, coins))
}
func change(amount int, coins []int) int {
	dp := make([]int, amount+1)
	//为0时 一个硬币都不选
	dp[0] = 1
	//dp[i] 表示金额为i时的方案数
	//遍历coins dp[i] = ∑dp[i - coins[j]]
	for _, coin := range coins {
		for i := 1; i < len(dp); i++ {
			if i-coin >= 0 {
				dp[i] += dp[i-coin]
			}
		}
	}
	return dp[amount]
}
