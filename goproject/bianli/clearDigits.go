package main

import (
	"goproject/utils"
	"strings"
	"unicode"
)

func main() {

}

func clearDigits(s string) string {
	r := []rune(s)
	size := len(s)
	needSkipCnts := 0
	var builder strings.Builder
	for i := size - 1; i >= 0; i-- {
		if unicode.IsDigit(r[i]) {
			needSkipCnts++
		} else {
			//不是字符
			if needSkipCnts > 0 {
				needSkipCnts--
			} else {
				builder.WriteRune(r[i])
			}
		}
	}
	return utils.ReverseString(builder.String())
}
