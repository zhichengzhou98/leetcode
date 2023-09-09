package com.zzc.template;

/**
 * @author zc.zhou
 * @Description 要求有序
 * @create 2023-09-03 17:25
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1,2,3,4};
        int target = 5;
        System.out.println(binarySearch.specificTarget(arr,target));
    }
    public boolean checkMed(int med,int target) {
        if (med > target) {
            return true;
        }
        return false;
    }

    //查找左边界: 满足checkMed的最小值
    public int leftBoundary(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(nums[med], target)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return nums[med];
    }

    //查找右边界
    public int rightBoundary(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int med = (r - l + 1 )/ 2 + l;
        while (l < r) {
            if (checkMed(med, target)) {
                l = med;
            }else {
                r = med - 1;
            }
            med = (r - l + 1 ) / 2 + l;
        }
        return med;
    }

    //查找指定值
    public int specificTarget(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int med = (r - l)/ 2 + l;
            if (target == nums[med]) {
                return med;
            }else if (target > med) {
                l = med + 1;
            }else {
                r = med -1;
            }
        }
        return res;
    }
}
