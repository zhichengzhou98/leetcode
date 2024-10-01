package main

func main() {

}

// 2414
func longestContinuousSubstring(s string) int {
	size := len(s)
	left := 0
	right := left + 1
	res := 1
	for right < size {
		for right < size && (int(s[right])-int(s[right-1])) == 1 {
			right++
		}
		res = max(res, right-left)
		left = right
		right = left + 1
	}
	return res
}
