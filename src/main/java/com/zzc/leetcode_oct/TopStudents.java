package com.zzc.leetcode_oct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-11 12:07
 */
public class TopStudents {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveSet = new HashSet<>(List.of(positive_feedback));

        Set<String> negativeSet = new HashSet<>(List.of(negative_feedback));
        List<int[]> idScore = new ArrayList<>();
        for (int i = 0; i < student_id.length; i++) {
            int id = student_id[i];
            String curReport = report[i];
            int score = 0;
            String[] split = curReport.split(" ");
            for (String s : split) {
                if (positiveSet.contains(s)) {
                    score += 3;
                } else if (negativeSet.contains(s)) {
                    score -= 1;
                }
            }
            idScore.add(new int[]{id, score});
        }
        idScore.sort((a, b)->{
            if (b[1] == a[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while (k > 0 && i < idScore.size()) {
            res.add(idScore.get(i)[0]);
            k--;
            i++;
        }
        return res;
    }
}
