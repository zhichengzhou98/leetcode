package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-07 22:35
 */
public class Demo10 {
    public static void main(String[] args) {

    }

    public boolean canWinNim(int n) {
      /*  if (n >= 1 && n <= 3) {
            return true;
        }
        //boolean[] res = new boolean[n];
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = false;
        for (int i = 3; i < n; i++) {
            d = !(a&&b&&c);
            a = b;
            b = c;
            c = d;
        }
        return d;*/
        return n % 4 != 0;
    }
}
