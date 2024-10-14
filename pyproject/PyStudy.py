str = "123456789"

print(str)
print(str[0: -1]) #0 到 倒数第二个字符
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

# 创建二维数组
rows, cols = 2, 3
dp = [[0] * cols for _ in range(rows)]