from functools import cache
from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        size = len(cost)

        # 爬到第n层所花费的费用
        @cache
        def dfs(n: int) -> int:
            if n >= size - 2:
                return 0
            return min(dfs(n + 1) + cost[n + 1], dfs(n + 2) + cost[n + 2])
        return min(dfs(0) + cost[0], dfs(1) + cost[1])

s = Solution()
costs = [1,100,1,1,1,100,1,1,100,1]
print(s.minCostClimbingStairs(costs))