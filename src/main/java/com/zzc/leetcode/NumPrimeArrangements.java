package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-18 17:30
 */
public class NumPrimeArrangements {
    public static void main(String[] args) {
        NumPrimeArrangements numPrimeArrangements = new NumPrimeArrangements();
        //System.out.println(numPrimeArrangements.isPrime(4));
        System.out.println(numPrimeArrangements.numOfPrime(100));
        System.out.println(numPrimeArrangements.factorial(25));
        System.out.println(numPrimeArrangements.numPrimeArrangements(2));
    }

    public boolean isPrime(int n) {
        //boolean flag = false;
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //n以内质数的个数
    public int numOfPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public int numPrimeArrangements(int n) {
        return (int) ((factorial(numOfPrime(n)) * factorial(n - numOfPrime(n))) % ((int)Math.pow(10,9) + 7));
    }

    public Long factorial(int n) {
        if (n == 1 || n == 0) {
            return 1L;
        }
        return n * factorial(n-1) % ((int)Math.pow(10,9) + 7);
    }

}
