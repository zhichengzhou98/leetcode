from typing import List


class Solution:
    # 3185 构成整天的下标对数目 map
    def countCompleteDayPairs(self, hours: List[int]) -> int:
        map = {}
        for h in hours:
            map[h % 24] = map.get(h % 24, 0) + 1
        res = 0
        for k in map.keys():
            cnt = map.get(k)
            if k == 0 or k == 12:
                res = res + cnt * (cnt - 1)
            else:
                res = res + cnt * map.get(24 - k, 0)
        return res // 2
s=Solution()
h = [12,12,30,24,24]
print(s.countCompleteDayPairs(h))