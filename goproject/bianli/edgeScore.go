package main

func edgeScore(edges []int) int {
	size := len(edges)
	//统计每个节点的分数
	scores := make([]int, size)
	maxScore := 0
	index := -1
	for i, value := range edges {
		scores[value] += i
		if scores[value] > maxScore {
			maxScore = scores[value]
			index = value
		} else if scores[value] == maxScore {
			index = min(index, value)
		}
	}
	return index
}
