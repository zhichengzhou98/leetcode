package com.zzc.leetcode_aug;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-01 19:36
 */
public class MergeTriplets {
    public static void main(String[] args) {
        System.out.println(mergeTriplets(new int[][]{{2,5,3},{1,8,4},{1,7,5}}, new int[]{2,7,5}));

    }
    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean flagOne = false;
        boolean flagTwo = false;
        boolean flagThree = false;
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1]&&triplet[2] <= target[2]) {
                if (triplet[0] == target[0]) {
                    flagOne = true;
                }
                if (triplet[1] == target[1]) {
                    flagTwo = true;
                }
                if (triplet[2] == target[2]) {
                    flagThree = true;
                }
            }
        }
        return flagOne && flagTwo&&flagThree;
    }

   /* public static boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean flagOne = false;
        boolean flagTwo = false;
        boolean flagThree = false;
        for (int[] triplet : triplets) {
            if (triplet[0] == target[0] && triplet[1] <= target[1]&&triplet[2] <= target[2]) {
                flagOne = true;
            }
            if (triplet[0] <= target[0] && triplet[1] == target[1]&&triplet[2] <= target[2]) {
                flagTwo = true;
            }
            if (triplet[0] <= target[0] && triplet[1] <= target[1]&&triplet[2] == target[2]) {
                flagThree = true;
            }
        }
        return flagOne && flagTwo&&flagThree;
    }*/
    /*public static boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean flagOne = false;
        boolean flagTwo = false;
        boolean flagThree = false;
        int[][] array = Arrays.stream(triplets).filter(
                a -> a[0] <= target[0] &&
                        a[1] <= target[1] &&
                        a[2] <= target[2]).toArray(int[][]::new);
        for (int[] a : array) {
            if (a[0] == target[0]) {
                flagOne = true;
            }
            if (a[1] == target[1]) {
                flagTwo = true;
            }
            if (a[2] == target[2]) {
                flagThree = true;
            }

        }

        return flagOne && flagTwo&&flagThree;
    }*/

    /*public static boolean mergeTriplets(int[][] triplets, int[] target) {
        AtomicBoolean flagOne = new AtomicBoolean(false);
        AtomicBoolean flagTwo = new AtomicBoolean(false);
        AtomicBoolean flagThree = new AtomicBoolean(false);
        int[][] array = Arrays.stream(triplets).filter(
                a -> a[0] <= target[0] &&
                        a[1] <= target[1] &&
                        a[2] <= target[2]).toArray(int[][]::new);
        for (int[] a : array) {
                if (a[0] == target[0]) {
                    flagOne.set(true);
                }
                if (a[1] == target[1]) {
                    flagTwo.set(true);
                }
                if (a[2] == target[2]) {
                    flagThree.set(true);
                }

        }

        return flagOne.get() && flagTwo.get() &&flagThree.get();
    }*/
}
