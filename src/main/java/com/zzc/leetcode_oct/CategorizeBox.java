package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-20 12:07
 */
public class CategorizeBox {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isHeavy = isHeavy(mass);
        boolean isBulky = isBulky(length, width, height, mass);
        if (isBulky && isHeavy) {
            return "Both";
        }else if (isBulky) {
            return "Bulky";
        }else if (isHeavy) {
            return "Heavy";
        }
        return "Neither";
    }

    public boolean isHeavy(int mass) {
        return mass >= 100;
    }

    public boolean isBulky(int length, int width, int height, int mass) {
        long v = (long) length * width * height;
        if (v >= Math.pow(10, 9)) {
            return true;
        }
        return length >= 10000 || width >= 10000 || height >= 10000 || mass >= 10000;
    }
}
