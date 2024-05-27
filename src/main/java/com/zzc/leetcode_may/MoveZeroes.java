package com.zzc.leetcode_may;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-08 20:36
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int currentIndex = 0;
        int zeroIndex = 0;
        while (true) {
            while (zeroIndex < nums.length && nums[zeroIndex] == 0) {
                zeroIndex++;
            }
            if (zeroIndex < nums.length) {
                nums[currentIndex] = nums[zeroIndex];
                currentIndex++;
                zeroIndex++;
            } else {
                break;
            }
        }
        while (currentIndex < nums.length) {
            nums[currentIndex] = 0;
            currentIndex++;
        }
    }

    @Test
    public void testFun() {
        int[] arr = {1, 2, 0, 3, 4};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
