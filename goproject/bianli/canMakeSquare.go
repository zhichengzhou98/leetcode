package main

func main() {

}

func canMakeSquare(grid [][]byte) bool {
	//遍历正方行的顶点
	for i := 0; i <= 1; i++ {
		for j := 0; j <= 1; j++ {
			if checkSingleSquare(i, j, grid) {
				return true
			}
		}
	}
	return false
}

// 判断当个正方是否满足 如果B W个数都是2 返回false.
// (a, b) 正方形左上定点
func checkSingleSquare(a int, b int, grid [][]byte) bool {
	cnt := 0
	for i := a; i <= a+1; i++ {
		for j := b; j <= b+1; j++ {
			if grid[i][j] == 'B' {
				cnt++
			}
		}
	}
	return cnt != 2
}
