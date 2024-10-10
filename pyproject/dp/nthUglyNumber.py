class Solution:
    # 264丑数
    def nthUglyNumber(self, n: int) -> int:
        dp = [0] * 1691
        dp[1] = 1
        p2 = 1
        p3 = 1
        p5 = 1
        for i in range(2, 1691):
            num2 = dp[p2] * 2
            num3 = dp[p3] * 3
            num5 = dp[p5] * 5
            dp[i] = min(num2, num3, num5)
            if dp[i] == num2:
                p2 += 1
            if dp[i] == num3:
                p3 += 1
            if dp[i] == num5:
                p5 += 1
        return dp[n]


solution = Solution()

print(solution.nthUglyNumber(1690))
