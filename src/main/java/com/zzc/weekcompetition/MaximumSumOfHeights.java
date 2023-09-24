package com.zzc.weekcompetition;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-24 10:38
 */
public class MaximumSumOfHeights {
    public static void main(String[] args) {
        MaximumSumOfHeights sum = new MaximumSumOfHeights();
        List<Integer> s1 = List.of(2,3,4,4,3,2,3,5,5,5);
        System.out.println(sum.maximumSumOfHeights(s1));
    }
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        //单调栈
        //6,5,3,9,2,7
        //0 为元素的值， 1 为个数
        Stack<int[]> s1 = new Stack<>();
        //前缀和 升序
        long[] sum1 = new long[maxHeights.size()];
        //从左到右遍历 maxHeights
        int first = maxHeights.get(0);
        s1.push(new int[]{first, 1});
        sum1[0] = first;
        for (int i = 1; i < maxHeights.size(); i++) {
            int cnt = 1;
            int current = maxHeights.get(i);
            while (!s1.isEmpty()) {
                int[] peekArr = s1.peek();
                int peek = peekArr[0];
                if (current > peek) {
                    //入栈
                    s1.push(new int[]{current, cnt});
                    sum1[i] += sum1[i-cnt] + (long) (cnt) * current;
                    break;
                }else if(current == peek) {
                    peekArr[1]+= cnt;
                    sum1[i] += sum1[i-cnt] + (long) (cnt) * current;
                    break;
                } else {
                    //栈顶出栈
                    s1.pop();
                    cnt += peekArr[1];
                }
            }
            if (s1.isEmpty()) {
                sum1[i] += (long) (i + 1) * current;
                s1.push(new int[]{current, cnt});
            }
        }

        //从后往前遍历
        Stack<int[]> s2 = new Stack<>();
        //后缀和 降序
        long[] sum2 = new long[maxHeights.size()];
        int len = sum2.length;
        int last = maxHeights.get(maxHeights.size() - 1);
        s2.push(new int[]{last, 1});
        sum2[len - 1] = last;
        for (int i = maxHeights.size() - 2; i >= 0 ; i--) {
            int cnt = 1;
            int current = maxHeights.get(i);
            while (!s2.isEmpty()) {
                int[] peekArr = s2.peek();
                int peek = peekArr[0];
                if (current > peek) {
                    //入栈
                    s2.push(new int[]{current, cnt});
                    sum2[i] += sum2[i + cnt] + (long) (cnt) * current;
                    break;
                }else if (current == peek){
                    peekArr[1]+= cnt;
                    sum2[i] += sum2[i + cnt] + (long) (cnt) * current;
                    break;
                }else {
                    //栈顶出栈
                    s2.pop();
                    cnt+= peekArr[1];
                }
            }
            if (s2.isEmpty()) {
                sum2[i] += (long) (len - i) * current;
                s2.push(new int[]{current, cnt});
            }
        }
        long max = sum1[sum1.length - 1];
        max = Math.max(max, sum2[0]);
        for (int i = 0; i < sum1.length - 1; i++) {
            max = Math.max(max, sum1[i] + sum2[i + 1]);
        }
        return max;
        /*for (int i = 1; i < maxHeights.size(); i++) {
            int current = maxHeights.get(i);
            int cnt = 1;
            while (!s1.isEmpty()) {
                Integer peek = s1.peek();
                if (current >= peek) {
                    //入栈
                    while (cnt > 0) {
                        cnt--;
                        sum1[i] = sum1[i - 1] + s1.push(current);
                    }
                }else {
                    //栈顶出栈
                    sum1[i] = sum1[i - 1] - s1.pop();
                    cnt++;
                }
            }
            while (cnt > 0) {
                cnt--;
                sum1[i] = sum1[i - 1] + s1.push(current);
            }
        }*/

    }

    /*public long maximumSumOfHeights(List<Integer> maxHeights) {
        //最大高度
        long[] res = new long[maxHeights.size()];
        //遍历maxHeights 以每个元素为顶
        for (int i = 0; i < maxHeights.size(); i++) {
            res[i] = getHighest(maxHeights, i);
        }
        return Arrays.stream(res).max().getAsLong();
    }*/

    /*public long maximumSumOfHeights(List<Integer> maxHeights) {
        long sumHeight = maxHeights.stream().mapToLong(Integer::longValue).sum();
        //以当前节点左边为顶时的高度差
        long[] left = new long[maxHeights.size()];
        //以当前节点右边为顶时的高度差
        long[] right = new long[maxHeights.size()];
        for (int i = 0; i < maxHeights.size(); i++) {
            if (i - 1 >= 0) {
                left[i] = Math.min(0, maxHeights.get(i - 1) - maxHeights.get(i));
            }
        }
        for (int i = maxHeights.size() - 1; i >= 0; i--) {
            if (i + 1 <= maxHeights.size() - 1) {
                right[i] = Math.min(0, maxHeights.get(i+1) - maxHeights.get(i));
            }
        }
        //求两个数组的前缀和
        double[] leftSum = new double[left.length];
        leftSum[0] = left[0];
        for (int i = 1; i < leftSum.length; i++) {
            leftSum[i] = leftSum[i - 1] + left[i];
        }

        double[] rightSum = new double[right.length];
        rightSum[0] = right[0];
        for (int i = 1; i < rightSum.length; i++) {
            rightSum[i] = rightSum[i - 1] + right[i];
        }
        long res = Integer.MIN_VALUE;
        double maxDiff = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        maxDiff = Math.max(maxDiff, rightSum[rightSum.length - 1]);
        res = Math.max(res, getHighest(maxHeights, maxHeights.size() - 1));
        res = Math.max(res, getHighest(maxHeights, 0));
        for (int i = 0; i < rightSum.length; i++) {
            double diff = 0;
            //以i 为顶点
            if (i == 0){
                diff =leftSum[leftSum.length - 1] - leftSum[i];
            }else {
               diff =rightSum[i - 1] +leftSum[leftSum.length - 1] - leftSum[i];
            }
            if (diff > maxDiff) {
                set.clear();
                set.add(i);
                maxDiff = diff;
            }else if (diff == maxDiff) {
                set.add(i);
            }
        }
        for (int i : set) {
            res= Math.max(res, getHighest(maxHeights, i));
        }
        return res;
    }*/

    /*public long maximumSumOfHeights(List<Integer> maxHeights) {
        //最大高度
        List<Long> res = new ArrayList<>();
        int max = maxHeights.stream().max((a, b) -> a - b).get();
        for (int i = 0; i < maxHeights.size(); i++) {
            if (maxHeights.get(i) == max) {
                res.add(getHighest(maxHeights, i));
            }
        }
        long maxRes = Integer.MIN_VALUE;
        for (int i = 0; i < res.size(); i++) {
            maxRes = Math.max(res.get(i), maxRes);
        }
        return maxRes;
    }*/

    public long getHighest(List<Integer> maxHeights, int i) {
        long current = maxHeights.get(i);
        long res = current;
        for (int j = i - 1; j >= 0 ; j--) {
            Integer pre = maxHeights.get(j);
            current = Math.min(current, pre);
            res = res + current;
        }
        current = maxHeights.get(i);
        for (int j = i + 1; j < maxHeights.size(); j++) {
            Integer next = maxHeights.get(j);
            current = Math.min(current, next);
            res = res + current;
        }
        return res;
    }
}
