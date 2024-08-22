package utils

func Max(nums ...int) int {
	res := nums[0]
	for _, val := range nums {
		if val > res {
			res = val
		}
	}
	return res
}

func MaxInt64(nums ...int64) int64 {
	res := nums[0]
	for _, val := range nums {
		if val > res {
			res = val
		}
	}
	return res
}

func Min(nums ...int) int {
	res := nums[0]
	for _, val := range nums {
		if val < res {
			res = val
		}
	}
	return res
}

func ArrayMin(arr []int) int {
	return min(arr[0], arr...)
}

func ArrayMax(arr []int) int {
	return max(arr[0], arr...)
}
