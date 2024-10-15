from collections import Counter
from typing import List

# 740. 删除并获得点数 o(nlogn)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # 统计每个数字出现的次数
        cntMap = Counter(nums)
        # 获取keys
        keys = sorted(cntMap.keys())
        size = len(keys)
        rows, cols = size, 3
        dp = [[0] * cols for _ in range(rows)]
        # dp[i][j] 前i个数的最大值 j: 0 不选第i个数 1 选第i个数 2 最大值
        dp[0][0] = 0
        dp[0][1] = keys[0] * cntMap.get(keys[0])
        dp[0][2] = dp[0][1]
        for i in range(1, size):
            key = keys[i]
            # 不选当前值
            dp[i][0] = dp[i - 1][2]
            # 选当前值 判断key-1是不是在cntMap中
            if keys[i - 1] == key - 1:
                # 不能选keys[i-1]
                dp[i][1] = dp[i - 1][0] + key * cntMap.get(key)
            else:
                # 不在cntMap中
                dp[i][1] = max(dp[i][1], dp[i - 1][2] + key * cntMap.get(key))
            dp[i][2] = max(dp[i][1], dp[i][0])
        return dp[size - 1][2]


s = Solution()
n = [3, 4, 2]
print(s.deleteAndEarn(n))
