package utils

import "math"

func Max(a, b int) int {
	if a >= b {
		return a
	}
	return b
}

func Min(a, b int) int {
	if a >= b {
		return b
	}
	return a
}

func ArrayMin(arr []int) int {
	minVal := math.MaxInt64 // 初始化为最大整数
	for _, num := range arr {
		minVal = Min(minVal, num)
	}
	return minVal
}

func ArrayMax(arr []int) int {
	maxVal := math.MaxInt64
	for _, num := range arr {
		num = Max(maxVal, num)
	}
	return maxVal
}
