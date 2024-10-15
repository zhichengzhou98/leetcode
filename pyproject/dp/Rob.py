from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        size = len(nums)
        dp = [0] * size
        if size == 1:
            return nums[0]
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])
        for i in range(2, size):
            # 考虑第i天是否偷
            # 偷：nums[i] + dp[i-2]; 不偷：dp[i-1]
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        return dp[size - 1]

s = Solution()
n=[1,2,3,1]
print(s.rob(n))