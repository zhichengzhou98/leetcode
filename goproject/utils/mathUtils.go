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
	return Min(arr...)
}

func ArrayMax(arr []int) int {
	return Max(arr...)
}
