package main

import "math"

func maxScoreSightseeingPair(values []int) int {
	//前i-1项数v[i] + i的最大值
	maxTmp := values[0] + 0
	size := len(values)
	res := math.MinInt64
	for i := 1; i < size; i++ {
		res = max(res, maxTmp+values[i]-i)
		maxTmp = max(maxTmp, values[i]+i)
	}
	return res
}
