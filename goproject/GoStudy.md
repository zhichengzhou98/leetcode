1.在 Go 语言中，数组的大小必须在编译时是一个常量。
```bash
# 编译不通过
size := len(arr) + 1
var sum [size]int64

#使用make创建切片
sum := make([]int64, size)
```

2.Go不会自动进行类型转换。
```bash
var a int = 42
var b int64 = 10000000000
# 需要将a转化为int64
result := int64(a) + b
```