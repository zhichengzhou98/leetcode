package main

func distanceBetweenBusStops(distance []int, start int, destination int) int {
	if destination < start {
		return distanceBetweenBusStops(distance, destination, start)
	}
	sum := 0
	tmpSUM := 0
	for i := 0; i < len(distance); i++ {
		sum += distance[i]
		if i >= start && i < destination {
			tmpSUM += distance[i]
		}
	}
	return min(tmpSUM, sum-tmpSUM)
}
