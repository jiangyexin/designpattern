package com.jyx.algorithm.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jiangyexin
 * @date 2021/9/16 17:04
 */
public class BaiduCodeInterviewWordCount {

    public static void main(String[] args) {

    }

    /**
     * Q：单词统计
     * @param str  一堆用空格隔开的单词
     * @return 根据单词出现的次数排序输出
     */
    private Map<Integer, List<String>> wordCounter(String str) {
        String[] strArr = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : strArr) {
            Integer count = map.get(s);
            if (count == null) {
                map.put(s, 1);
            } else {
                count++;
                map.put(s, count);
            }
        }
        Map<Integer, List<String>> mapCount = new TreeMap<>();

        for (String key :map.keySet()) {
            Integer count = map.get(key);
            List<String> strings = mapCount.get(count);
            if (strings == null) {
                strings = new LinkedList<>();
                strings.add(key);
            } else {
                strings.add(key);
            }
        }
        return mapCount;
    }

    /**
     * Q：单链表反转
     * @param root
     * @return
     */
    private MyNode revert(MyNode root) {
        if (root == null) {
            return root;
        }
        MyNode pre = root;
        MyNode cur = root.next;
        while (cur != null) {
            MyNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
    class MyNode {
        public int val;
        public MyNode next;
    }
}
