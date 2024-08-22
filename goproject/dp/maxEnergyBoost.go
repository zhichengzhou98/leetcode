package main

import (
	"fmt"
)

func main() {
	energyDrinkA := []int{4, 1, 1}
	energyDrinkB := []int{1, 1, 3}
	fmt.Println(maxEnergyBoost(energyDrinkA, energyDrinkB))

}
func maxEnergyBoost(energyDrinkA []int, energyDrinkB []int) int64 {
	size := len(energyDrinkA)
	dp := make([][2]int64, size)
	//dp[i][0]: 第i小时 且最后一喝A
	dp[0][0] = int64(energyDrinkA[0])
	dp[0][1] = int64(energyDrinkB[0])
	dp[1][0] = dp[0][0] + int64(energyDrinkA[1])
	dp[1][1] = dp[0][1] + int64(energyDrinkB[1])
	for i := 2; i < size; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-2][1]) + int64(energyDrinkA[i])
		dp[i][1] = max(dp[i-1][1], dp[i-2][0]) + int64(energyDrinkB[i])
	}
	return max(dp[size-1][0], dp[size-1][1])
}
