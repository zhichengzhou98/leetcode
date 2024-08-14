package main

import "fmt"

func main() {
	fmt.Println(numTrees(5))
}

func numTrees(n int) int {
	dp := make([]int, n+1)

	//空树有一个节点
	dp[0] = 1
	for i := 1; i < len(dp); i++ {
		//表示有i个数字， 分别以每个数字为根节点构建树
		res := 0
		for j := 1; j <= i; j++ {
			//根节点为j, j左子树有 1 - j - 1个节点
			//j右子树有i-j个节点
			res = res + dp[j-1]*dp[i-j]
		}
		dp[i] = res
	}
	return dp[n]
}
