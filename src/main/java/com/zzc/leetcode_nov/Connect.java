package com.zzc.leetcode_nov;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-03 12:06
 */
public class Connect {
    @Test
    public void test() {
        Node noed1 = new Node(1);

        Node noed2 = new Node(2);
        Node noed3 = new Node(3);
        noed1.left = noed2;
        noed1.right = noed3;
        connect(noed1);
    }
    public Node connect(Node root) {
        //层序遍历
        if (root == null) {
            return root;
        }
        List<Node> list = new ArrayList<>();
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Node current = list.remove(0);
                if (i < size - 1) {
                    current.next = list.get(0);
                }else {
                    current.next = null;
                }

                if (current.left != null) {
                    list.add(current.left);
                }
                if (current.right != null) {
                    list.add(current.right);
                }
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}