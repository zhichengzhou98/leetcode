package main

import "fmt"

func main() {
	for i := range 3 {
		fmt.Println(i)
	}
	b := "123"
	flag := false
	if flag {
		fmt.Println(b)
	}
	fmt.Println("Hello, 世界")
}
