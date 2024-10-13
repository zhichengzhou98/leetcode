from functools import cache

"""
70. 爬楼梯
509. 斐波那契数
1137. 第 N 个泰波那契数
"""


class Solution:
    def tribonacci(self, n: int) -> int:
        @cache
        def dfs(n: int) -> int:
            if n == 0:
                return 0
            if n == 1 or n == 2:
                return 1
            return dfs(n - 1) + dfs(n - 2) + dfs(n - 3)

        return dfs(n)

    def fib(self, n: int) -> int:
        @cache
        def dfs(n: int) -> int:
            if n == 0:
                return 0
            if n == 1:
                return 1
            return dfs(n - 1) + dfs(n - 2)

        return dfs(n)

    def climbStairs(self, n: int) -> int:
        @cache
        def dfs(n: int) -> int:
            if n == 1:
                return 1
            if n == 2:
                return 2
            return dfs(n - 1) + dfs(n - 2)

        return dfs(n)
