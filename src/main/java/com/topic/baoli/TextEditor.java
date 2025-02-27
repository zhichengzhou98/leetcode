package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 2296. 设计一个文本编辑器 双链表
 * @create 2025-02-27 21:23
 */
public class TextEditor {
  public static void main(String[] args) {
    TextEditor tx = new TextEditor();
    tx.addText("leetcode");
    System.out.println(tx.deleteText(4));
    tx.addText("practice");
    System.out.println(tx.cursorRight(3));
    System.out.println(tx.cursorLeft(8));
    System.out.println(tx.deleteText(10));
    System.out.println(tx.cursorRight(6));
  }
  String text;
  int cur;
  public TextEditor() {
    text = "";
    cur = 0;
  }

  public void addText(String text) {
    this.text = this.text.substring(0, cur) + text + this.text.substring(cur);
    cur = cur + text.length();
  }

  public int deleteText(int k) {
    int left = Math.max(0, cur - k);
    this.text = this.text.substring(0, left) + this.text.substring(cur);
    int res = cur - left;
    cur = left;
    return res;
  }

  public String cursorLeft(int k) {
    int left = Math.max(0, cur - k);
    cur = left;
    return this.text.substring(Math.max(0, cur - 10), cur);
  }

  public String cursorRight(int k) {
    int right = Math.min(this.text.length(), cur + k);
    cur = right;
    return this.text.substring(Math.max(0, cur - 10), cur);
  }
}
