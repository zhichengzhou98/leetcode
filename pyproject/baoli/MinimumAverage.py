from typing import List


class Solution:
    # 3194
    def minimumAverage(self, nums: List[int]) -> float:
        res = 50.0
        sortedNums = sorted(nums)
        size = len(nums)
        for i in range(0, size // 2):
            res = min(res, (sortedNums[i] + sortedNums[size - 1 - i]) / 2)
        return res


s = Solution()
nums1 = [7, 8, 3, 4, 15, 13, 4, 1]
print(s.minimumAverage(nums1))
