package com.jyx.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static sun.nio.ch.IOStatus.check;

/**
 * @author jiangyexin
 * @date 2021/8/10 15:07
 */
public class LeetCodeLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        //reverseList(l1);
        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);
        ListNode ll3 = new ListNode(3);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = null;
        //reverseBetween(ll1, 1, 2);
        isPalindrome("race a car");
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/
     * 用栈反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        while (head.next != null) {
            head = head.next;
            stack.push(head);
        }
        ListNode rvHead = stack.peek();
        while (!stack.empty()) {
            ListNode l = stack.pop();
            if (!stack.empty()) {
                l.next = stack.peek();
            } else {
                l.next = null;
            }
        }
        return rvHead;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * 反转部分链表
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left > right) {
            return null;
        }
        if (left == right) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode tou = head,pos1 = new ListNode(),pos2 = new ListNode();
        int len = 0;
        for (int i = 0; i <= right; i++) {
            //将要反转的段入栈
            if (i >= left -1 && i < right) {
                stack.push(tou);
            }
            //记录断点头
            if (i == left - 2) {
                pos1 = tou;
            }
            //记录断点尾
            if (i == right) {
                pos2 = tou;
            }
            if (tou != null) {
                len++;
                tou = tou.next;
            }
        }
        //反转部分
        ListNode rvHead = stack.peek();
        while (!stack.empty()) {
            ListNode l = stack.pop();
            if (!stack.empty()) {
                l.next = stack.peek();
            } else {
                l.next = pos2;
            }
        }
        pos1.next = rvHead;
        //链表长度为2或者反转的开始位置是头结点直接返回栈
        if (len == 2 || left == 1) {
            return rvHead;
        }
        return head;
    }

    /**
     * 合并k个有序链表
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
           return null;
        }
        //虚拟头结点
        ListNode dummyHead = new ListNode();
        ListNode head = dummyHead;
        boolean flag = true;

        while (flag) {
            int min = Integer.MAX_VALUE;
            int lseq = -1;
            int finish = 0;
            for (int i = 0; i < lists.length; i++) {
                //找一个最小值
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    lseq = i;
                }
                //每遍历完一个finish+1
                if (lists[i] == null) {
                    finish++;
                }
            }
            //没有遍历完，则一定有结点被添加到合并后的链表
            if (finish != lists.length) {
                dummyHead.next = lists[lseq];
                dummyHead = dummyHead.next;
                lists[lseq] = lists[lseq].next;
            }
            //如果所有链表都遍历完了则结束循环
            if (finish == lists.length) {
                flag = false;
            }
        }
        return head.next;
    }

    /**
     * 最长回文串
     * 特点：最多有一个字符出现一次，其他的都是偶数次
     * https://leetcode-cn.com/problems/longest-palindrome/
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        //统计字符出现的次数
        for (char c : arr) {
            Integer count = countMap.get(c);
            if (count == null) {
                countMap.put(c,1);
            } else {
                countMap.put(c, count + 1);
            }
        }
        int len = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            //出现偶数次，直接作为回文串长度
            if (entry.getValue() % 2 == 0) {
                len = len + entry.getValue();
            } else {
                //出现奇数次，次数-1作为回文串长度
                len = len + entry.getValue() - 1;
                //标记有字符出现奇数次
                flag = true;
            }
        }
        //如果出现的字符都是偶数次则返回len，如果出现的字符中有奇数次则返回 len + 1
        return flag ? len + 1 : len;
    }

    /**
     * 回文链表
     * https://leetcode-cn.com/problems/aMhZSa/
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode dummyHead = new ListNode(), judgeHead = new ListNode();
        judgeHead.next = head;
        dummyHead.next = head;
        Stack<ListNode> stack = new Stack();
        //遍历链表入栈
        while (dummyHead.next != null) {
            dummyHead = dummyHead.next;
            stack.push(dummyHead);
        }
        //栈中的数据与链表中的数据比较
        while (judgeHead.next != null) {
            ListNode stackNode = stack.pop();
            judgeHead = judgeHead.next;
            if (judgeHead.val != stackNode.val) {
                return false;
            }
        }
        return true;
    }

    /**
     * 有效回文串
     * https://leetcode-cn.com/problems/XltzEq/
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //过滤左指针无效字符
            while (left < right && !check(s.charAt(left))) {
                left++;
            }
            //过滤右指针无效字符
            while (left < right && !check(s.charAt(right))) {
                right--;
            }
            //比较
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            //左右指针移动
            left++;
            right--;
        }
        return true;
    }

    private static boolean check(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
