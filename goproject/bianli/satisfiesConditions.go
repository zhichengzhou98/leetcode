package main

func main() {

}
func satisfiesConditions(grid [][]int) bool {
	m := len(grid)
	n := len(grid[0])
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			//check right
			if j+1 < n && grid[i][j] == grid[i][j+1] {
				return false
			}
			if i+1 < m && grid[i][j] != grid[i+1][j] {
				return false
			}
		}
	}
	return true
}
