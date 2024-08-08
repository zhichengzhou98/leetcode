package main

// 3131 遍历

func addedInteger(nums1 []int, nums2 []int) int {
	min1 := nums1[0]
	min2 := nums2[0]
	for i := 1; i < len(nums1); i++ {
		min1 = min(min1, nums1[i])
		min2 = min(min2, nums2[i])
	}
	return min2 - min1
}

func min(a, b int) int {
	if a <= b {
		return a
	}
	return b
}
