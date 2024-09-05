package utils

func ReverseString(s string) string {
	r := []rune(s)
	size := len(s)
	for left, right := 0, size-1; left < right; left, right = left+1, right-1 {
		r[left], r[right] = r[right], r[left]
	}
	return string(r)
}
