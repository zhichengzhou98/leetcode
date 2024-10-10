class Solution:
    # 1227. 飞机座位分配概率 dp + 前缀和优化
    def nthPersonGetsNthSeat(self, n: int) -> float:
        dp = [0.0] * (n + 1)
        preSum = [0.0] * (n + 1)
        dp[1] = 1
        preSum[1] = 1
        for i in range(2, n + 1):
            dp[i] = preSum[i - 1] / i
            preSum[i] = dp[i] + preSum[i - 1]
        return dp[n]

# 创建 Solution 类的实例
solution = Solution()

# 调用 nthPersonGetsNthSeat 方法
res = solution.nthPersonGetsNthSeat(5)

print(res)
