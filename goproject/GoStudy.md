1.在 Go 语言中，数组的大小必须在编译时是一个常量。
```text
# 编译不通过 数组长度不能使用变量
size := len(arr) + 1
var sum [size]int64

#使用make创建切片
sum := make([]int64, size)

#创建二维切片
sum := make([][2]int64, size)

#二维长度为变量时：
dp := make([][]int, len(grid))
for i := range dp {
    dp[i] = make([]int, len(grid[0])) // 为每一行分配内存
}
```

2.Go不会自动进行类型转换。
```text
var a int = 42
var b int64 = 10000000000
# 需要将a转化为int64
result := int64(a) + b
```

3.获取字符串中的某个字符
字符串索引：s[i] 会返回 s 中第 i 个字符的 ASCII 或 UTF-8 编码值（类型是 byte），因此你可以用 %c 格式化输出以显示字符。

Unicode 字符：如果字符串包含非 ASCII 字符（例如中文、日文或表情符号），s[i] 仍然会返回该字符的 UTF-8 编码的
第一个字节，而不是整个字符。对于这种情况，你应该使用 rune 类型。

```text
s := "Hello World"
c1 := s[0]
c2 := s[1]

s := "Hello, 世界"
r := []rune(s) // 将字符串转换为 rune 切片
fmt.Printf("字符: %c\n", r[7]) // 获取索引为7的字符，即'世'
```