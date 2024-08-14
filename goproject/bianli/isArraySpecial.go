package main

// 3152
func main() {

}
func isArraySpecialV1(nums []int) bool {
	for i := 1; i < len(nums); i++ {
		if (nums[i]+nums[i-1])%2 == 0 {
			return false
		}
	}
	return true
}

func isArraySpecial(nums []int, queries [][]int) []bool {
	querySize := len(queries)
	size := len(nums)
	res := make([]bool, querySize)
	temp := make([]int, size)
	current := 0
	for i := 1; i < size; i++ {
		if (nums[i]+nums[i-1])%2 == 0 {
			current++
		}
		temp[i] = current
	}
	for i := 0; i < querySize; i++ {
		res[i] = temp[queries[i][0]] == temp[queries[i][1]]
	}
	return res
}
