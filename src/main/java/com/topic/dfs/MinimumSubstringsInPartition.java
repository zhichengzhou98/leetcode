package com.topic.dfs;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 3144 v2 dfs
 * @create 2024-08-28 10:46
 */
public class MinimumSubstringsInPartition {
  @Test
  void testFun() {
    String str = "mzxnppqqvxtszzodqodzzcvvvccoooooaajjjjeqkkkkbbbihhiaaaphcwwwwjdsxbjjffnnxqeczzxemmohpolmsonlnouuuwrrzqmmmmmokkdxyuttghwwbjcpnrdoomstpqqpeflzpjkhkcvxcrrmruqoojczuuuuinkkmefstbuxxrkdwvedqqkksmmfffmmgvvdxwflmvwwwumlmmtssrswlededbzvvgabbzfddlmlhqvxandyohaapkftgvbggebbhtushbbbbaagjkkpphhebyeecccdffgeklrurnppmczlmmjnerttpzycccvvnqmqqefvtugmjjmjqlllhhxmlezdciicuwwbbtsduudocnbppppiiagglxvvhhtnoprrseefdqaxjslnsjjqddeddeetjgewnjjqppihhgggttllppeeggwffottonggddurddnmfbbvvvclqqyyflwbcwgmmpkmmhhbonozzzlyyvzznjjqnnnjmdtueixkttunnnizmlvvvllzctvtooqmlbbbbbwwwmyyfrrrrvvxdghwtbxmmmkwfiqqlzuvjoopmmykavvvegghhgweyuiindukhmttvvyyyiiqhiffmltmmmaaxxulmmrrggirhrropxxxwwbqxqmtgftplhnbwsrfffjsqqljwuudzqkjcblxxxfcjoqopolqzjkfyxqtiesrrppndvtsmmmfxxxwnojggttcbaoolneeldistzhpeeprrhjcmwralkmmkkudwwffffpttreerpprrrhfhhizqunnxdkkkwwcbbzxotovicccgrdlwflkkzywvyywvrdvjdcnfbuveqppseyyyqqqveewusmbddcholmuzqpqhdkjijjzkbvvlttqaiqqqqqqpebbmznnyjqpprpzzzuqqfcfzfacclmhigmnyqeoefdkxvpqqqggoeiyyuuyzddlobkwwfdrkkgboookaalhhhukor";
    System.out.println(minimumSubstringsInPartition(str));
  }


  Map<Integer, Integer> map;
  public int minimumSubstringsInPartition(String s) {
    int len = s.length();
    map = new HashMap<>();
    //1 2 3 ... len
    return dfsV1(len - 1, s);
  }

  //abcfra len = 6 right = 5
  private int dfsV1(int right, String s) {
    if (right == -1) {
      return 0;
    }
    if (map.containsKey(right)) {
      return map.get(right);
    }
    int[] cnts = new int[26];
    int res = Integer.MAX_VALUE;
    int k = 0; // 字符的种树
    int maxCnt = 0; //最大字符出现的次数
    for (int i = 0; i <= right; i++) {
      int cIndex = s.charAt(right - i) - 'a';
      if (cnts[cIndex] == 0) {
        k++;
      }
      cnts[cIndex]++;
      maxCnt = Math.max(maxCnt, cnts[cIndex]);
      if (maxCnt * k == (i + 1)) {
        res = Math.min(res, dfsV1(right - i - 1, s) + 1);
      }
    }
    map.put(right, res);
    return res;
  }


  //abcfra len = 6 right = 5
  private int dfs(int right, String s) {
    if (right == -1) {
      return 0;
    }
    if (map.containsKey(right)) {
      return map.get(right);
    }
    int[] cnts = new int[26];
    int res = Integer.MAX_VALUE;
    for (int i = 0; i <= right; i++) {
      cnts[s.charAt(right - i) - 'a']++;
      if (checkCnt(cnts)) {
        res = Math.min(res, dfs(right - i - 1, s) + 1);
      }
    }
    map.put(right, res);
    return res;
  }

  private boolean checkCnt(int[] cnts) {
    Set<Integer> set = new HashSet<>();
    for (int nums : cnts) {
      if (nums != 0) {
        set.add(nums);
      }
    }
    return set.size() <= 1;
  }
}
