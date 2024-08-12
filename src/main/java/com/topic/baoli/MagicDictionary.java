package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 676 o(qmn) 数组长度 * 字符串长度 * search调用次数
 * @create 2024-08-12 9:17
 */
public class MagicDictionary {
  String[] dic;

  public MagicDictionary() {

  }

  public void buildDict(String[] dictionary) {
    this.dic = dictionary;
  }

  public boolean search(String searchWord) {
    for (String word : dic) {
      if (checkSingleWord(searchWord, word)) {
        return true;
      }
    }
    return false;
  }

  private boolean checkSingleWord(String target, String word) {
    if (target.length() != word.length()) {
      return false;
    }
    if (target.equals(word)) {
      return false;
    }
    int cnts = 0;
    for (int i = 0; i < target.length(); i++) {
      if (target.charAt(i) != word.charAt(i)) {
        cnts++;
      }
    }
    return cnts == 1;
  }

}
