from collections import Counter
from typing import List


class Solution:
    # 3158
    def duplicateNumbersXOR(self, nums: List[int]) -> int:
        map = Counter(nums)
        res = 0
        for n, cnt in map.items():
            if cnt == 2:
                res ^= n
        return res


s = Solution()
nums1 = [10, 18, 7, 10, 18]
print(s.duplicateNumbersXOR(nums1))
