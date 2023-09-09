package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-13 21:30
 */
public class Demo13 {
    public static void main(String[] args) {

    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int middle = (right - left) / 2 + left;
        while (guess(middle) != 0) {
            if(guess(middle) == 1) {
                left = middle +1;
            }else {
                right = middle -1;
            }
            middle = (right - left) / 2 + left;
        }
        return middle;
    }
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

    public int guess(int num) {
        return 0;
    }
}
