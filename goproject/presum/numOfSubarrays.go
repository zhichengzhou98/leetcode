package main

import "fmt"

func main() {
	arr := []int{100, 10, 3, 3}
	fmt.Println(numOfSubarrays(arr))

}

const MOD int64 = 1e9 + 7

func numOfSubarrays(arr []int) int {
	size := len(arr) + 1
	//前缀和
	sum := make([]int64, size)
	//前缀奇数和 偶数和
	even := make([]int, size)
	even[0] = 1
	odd := make([]int, size)
	var res int64 = 0
	for i := 1; i < len(sum); i++ {
		sum[i] = sum[i-1] + int64(arr[i-1])
		even[i] = even[i-1]
		odd[i] = odd[i-1]
		if sum[i]%2 == 0 {
			even[i]++
			res = (res + int64(odd[i-1])) % MOD
		} else {
			odd[i]++
			res = (res + int64(even[i-1])) % MOD
		}
	}
	return int(res % MOD)
}
