str = "123456789"

print(str)
print(str[0: -1])  # 0 到 倒数第二个字符
print(str[0: len(str) - 3])

# 创建map
map = {}
map[1] = "a"
map[2] = "b"
map[3] = "c"
print(map)
map[1] = "d"
print(map)
# 后去map中所有的keys
set = map.keys()

# and or not

# 倒序遍历
for i in range(10, 5, -1):
    print(i)  # 10 9 8 7 6

# -1 表示打印最后一个元素
print("============")
arr = [0, 1, 2]
print(arr[-1])


# 创建二维数组
rows, cols = 2, 3
dp = [[0] * cols for _ in range(rows)]