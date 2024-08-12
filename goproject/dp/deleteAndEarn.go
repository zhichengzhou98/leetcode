package main

import (
	"fmt"
	"goproject/utils"
	"sort"
)

func main() {
	arr := []int{4, 10, 10, 8, 1, 4, 10, 9, 7, 6}
	fmt.Println(deleteAndEarn(arr))

}

func deleteAndEarn(nums []int) int {
	//排序
	sort.Ints(nums)
	size := len(nums)
	//var dp [size][2]int; × 不能使用变量size, 应该创建切片
	// 创建一个二维切片，大小为 size x 2
	dp := make([][2]int, size)

	dp[0][0] = 0
	dp[0][1] = nums[0]
	for i := 1; i < size; i++ {
		current := nums[i]
		pre := nums[i-1]
		if current == pre {
			dp[i][0] = dp[i-1][0]
			dp[i][1] = dp[i-1][1] + current
		} else if current == pre+1 {
			dp[i][0] = utils.Max(dp[i-1][0], dp[i-1][1])
			dp[i][1] = dp[i-1][0] + current
		} else {
			dp[i][0] = utils.Max(dp[i-1][0], dp[i-1][1])
			dp[i][1] = utils.Max(dp[i-1][0], dp[i-1][1]) + current
		}
	}
	return utils.Max(dp[size-1][0], dp[size-1][1])
}
