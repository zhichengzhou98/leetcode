from collections import Counter
from typing import List


class Solution:
    # 3164. 优质数对的总数 II 枚举
    def numberOfPairs(self, nums1: List[int], nums2: List[int], k: int) -> int:
        map1 = Counter(nums1)
        map2 = Counter(nums2)
        max1 = max(nums1)
        # 枚举倍数
        res = 0
        for n2, cnt2 in map2.items():
            tmp = k * n2
            for i in range(1, max1 // tmp + 1):  # i 从 1 开始，到 max1//tmp 为止
                res += map1.get(i * tmp, 0) * cnt2
        return res

    def numberOfPairsV1(self, nums1: List[int], nums2: List[int], k: int) -> int:
        map1 = {}
        map2 = {}
        max1 = nums1[0]
        for n1 in nums1:
            map1[n1] = map1.get(n1, 0) + 1
            max1 = max(max1, n1)
        for n2 in nums2:
            map2[n2] = map2.get(n2, 0) + 1
        # 枚举倍数
        res = 0
        for n2 in map2.keys():
            tmp = k * n2
            for i in range(1, max1 // tmp + 1):  # i 从 1 开始，到 max1//tmp 为止
                tar = i * tmp
                if tar <= max1:
                    res += map1.get(tar, 0) * map2.get(n2, 0)
        return res


solution = Solution()
num1 = [1, 3, 4]
num2 = [1, 3, 4]
print(solution.numberOfPairs(num1, num2, 1))
