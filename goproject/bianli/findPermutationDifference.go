package main

func main() {

}
func findPermutationDifference(s string, t string) int {
	size := len(s)
	res := make([][2]int, 26)
	for i := 0; i < size; i++ {
		c1 := s[i] - 'a'
		c2 := t[i] - 'a'
		res[c1][0] = i
		res[c2][1] = i
	}
	cnt := 0
	for i := 0; i < 26; i++ {
		cnt += abs(res[i][0] - res[i][1])
	}
	return cnt
}
