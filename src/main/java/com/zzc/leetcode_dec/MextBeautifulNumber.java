package com.zzc.leetcode_dec;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-09 19:28
 */
public class MextBeautifulNumber {
    public int nextBeautifulNumber(int n) {
        int[] arr = {
                1, 22, 122, 212, 221, 333, 4444, 1333, 3133, 3313, 3331,
                55555, 14444, 41444, 44144, 44414, 44441, 22333, 23233, 23323, 23332,
                32233, 32323, 32332, 33223, 33232, 33322, 122333, 123233, 123323, 123332,
                132233, 132323, 132332, 133223, 133232, 133322, 212333, 213233, 213323,
                213332, 221333, 223133, 223313, 223331, 231233, 231323, 231332, 232133,
                232313, 232331, 233123, 233132, 233213, 233231, 233312, 233321, 312233,
                312323, 312332, 313223, 313232, 313322, 321233, 321323, 321332, 322133,
                322313, 322331, 323123, 323132, 323213, 323231, 323312, 323321, 331223,
                331232, 331322, 332123, 332132, 332213, 332231, 332312, 332321, 333122,
                333212, 333221, 224444, 242444, 244244, 244424, 244442, 422444, 424244,
                424424, 424442, 442244, 442424, 442442, 444224, 444242, 444422, 155555,
                515555, 551555, 555155, 555515, 555551, 666666,1224444};
        Arrays.sort(arr);
        for(int i :arr) {
            if (i >n) {
                return i;
            }
        }
        return arr[arr.length-1];
    }

    List<String> res;
    @Test
    public void test() {
        List<Integer> arr = new ArrayList<>(List.of(1,5,5,5,5,5));
        res = new ArrayList<>();
        dfs(arr, "");
        System.out.println(res);
    }

    public void dfs(List<Integer> list, String str) {
        if (list.isEmpty()) {
            res.add(str);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i).intValue() == list.get(i - 1)) {
                continue;
            }
            List<Integer> copy = new ArrayList<>(list);
            Integer remove = copy.remove(i);
            str += remove;
            dfs(copy, str);
            str = str.substring(0, str.length()-1);
        }
    }
}
