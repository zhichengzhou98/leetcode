from typing import List


class Solution:
    # 2915和为目标值的最长子序列的长度
    def lengthOfLongestSubsequence(self, nums: List[int], target: int) -> int:
        size = len(nums)
        # dp[i][j]: 表示nums[0] 到nums[i] 和为j的最长子序列的长度
        dp = []
        for i in range(size):
            dp.append([-1] * (target + 1))
        if nums[0] <= target:
            dp[0][nums[0]] = 1
        dp[0][0] = 0
        for i in range(1, size):
            # 考虑第i个数选或者不选
            for j in range(target, -1, -1):
                # 不选第i个数
                dp[i][j] = dp[i - 1][j]
                if j - nums[i] >= 0 and dp[i - 1][j - nums[i]] != -1:
                    # 不选: dp[i-1][j] 选:dp[i-1][j-num[i]]
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - nums[i]] + 1)
        return dp[size - 1][target]


s = Solution()
print(s.lengthOfLongestSubsequence([1, 3, 3, 8], 7))
