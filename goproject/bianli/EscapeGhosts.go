package main

import "math"

// 789
// 统计每个ghosts到target的曼哈顿距离|🔺x| + |🔺y|
// 如果ghost能在角色到达target之前拦截，就一定能在target位置拦截

func escapeGhosts(ghosts [][]int, target []int) bool {
	var distance int
	distance = getManDistance(target[0], target[1])
	minDistance := math.MaxInt
	for _, value := range ghosts {
		x := value[0] - target[0]
		y := value[1] - target[1]
		newDis := getManDistance(x, y)
		minDistance = int(math.Min(float64(newDis), float64(minDistance)))
	}
	return distance < minDistance
}

func getManDistance(x, y int) int {
	return abs(x) + abs(y)
}

func abs(x int) int {
	return int(math.Abs(float64(x)))
}
