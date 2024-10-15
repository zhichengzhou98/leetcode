import math


class Solution:
    # 3200 三角形最大高度 数学法
    def maxHeightOfTriangle(self, red: int, blue: int) -> int:
        def maxH(r: int, b: int) -> int:
            # 首行放红球 1 + 3 + ... + (2n-1)
            n1 = math.floor(math.sqrt(r))
            h1 = 2 * n1 - 1
            # 2 + 4 + 6 + ... 2n => n + n²
            n2 = math.floor(math.sqrt(b + 0.25) - 0.5)
            h2 = 2 * n2
            return max(min(h1 + 1, h2), min(h1, h2 + 1))
        return max(maxH(red, blue), maxH(blue, red))
s = Solution()
print(s.maxHeightOfTriangle(2,4))

