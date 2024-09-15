package main

// 3285. 找到稳定山的下标
func stableMountains(height []int, threshold int) []int {
	var list []int
	size := len(height)
	for i := 0; i < size-1; i++ {
		if height[i] > threshold {
			list = append(list, i+1)
		}
	}
	return list
}
