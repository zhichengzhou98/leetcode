package com.zzc.leetcode_oct;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-31 21:53
 */
public class SmallestMissingValueSubtree {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] p = new int[]{-1,0,1,0,3,3};
        int[] nums = new int[]{5,4,6,2,1,3};
        System.out.println(Arrays.toString(smallestMissingValueSubtree(p, nums)));

    }

    Map<Integer, Set<Integer>> map;
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        //childList[i] 表示第i个节点的子节点列表
        List[] childList = new List[parents.length];
        for (int i = 0; i < childList.length; i++) {
            childList[i] = new ArrayList<Integer>();
        }
        int root = -1;
        for (int i = 0; i < parents.length; i++) {
            int parent = parents[i];
            if (parent != -1) {
                childList[parent].add(i);
            }else {
                root = i;
            }
        }
        map = new HashMap<>();
        int max = Arrays.stream(nums).boxed().max(Integer::compareTo).get() + 1;
        dfs(root, childList, nums);
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            Set<Integer> set = map.get(i);
            for (int j = 1; j <= max; j++) {
                if (!set.contains(j)) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

    //以node结点为根结点的所有值
    public Set<Integer> dfs(int node, List[] childList, int[] nums) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        //获取node节点的子节点
        Set<Integer> set = new HashSet<>();
        List<Integer> children = childList[node];
        for (int i : children) {
            set.addAll(dfs(i, childList, nums));
        }
        set.add(nums[node]);
        map.put(node, set);
        return set;
    }
}
