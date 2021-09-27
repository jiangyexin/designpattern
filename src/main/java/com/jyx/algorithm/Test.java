package com.jyx.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: jiangyexin
 * @Description:
 * 算法
 * 1、排序
 * 选择排序、插入排序、希尔排序、归并排序、快速排序、堆排序（优先队列）
 * 2、查找
 * 顺序查找（基于无序链表）、二分查找（基于有序数组）、二叉查找树、
 * 平衡查找树 {
 *            2-3查找树
 *            红黑二叉查找树
 * }
 * 散列表
 * @Date: 2018-08-22 13:55
 **/
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.hashCode();
        test.equals(test.hashCode());

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.add(1);

        int i = queue.poll();
        int j = queue.remove();

        int k = queue.peek();

        queue.size();

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(4);
        stack.push(7);

        int a = stack.pop();
        int b = stack.peek();

        stack.empty();


        Queue<Integer> priorityQueue = new PriorityQueue<Integer>(comparator);
        priorityQueue.offer(9);
        priorityQueue.offer(5);
        priorityQueue.offer(7);
        priorityQueue.offer(3);
        priorityQueue.offer(6);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
        ReentrantLock lock = new ReentrantLock();
        ThreadLocal t = new ThreadLocal();
        Condition condition = lock.newCondition();
    }
    public static Comparator<Integer> comparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return  o1 < o2 ? 1 : -1;
        }
    };

    /*二叉树遍历*/
    class Node {
        public Node left;
        public Object data;
        public Node right;
    }
    public static List<Object> visitor = new LinkedList<>();
    public static void binScan(Node root) {
        while (root != null) {
            /*先序遍历 中左右*/
            visitor.add(root.data);
            binScan(root.left);
            binScan(root.right);

            /*中序遍历 左中右*/
            /*binScan(root.left);
            visitor.add(root);
            binScan(root.right);*/

            /*后序遍历 左右中*/
            /*binScan(root.left);
            binScan(root.right);
            visitor.add(root);*/
        }
    }

    /**
     * 求二叉树的高度
     * @param root
     * @return
     */
    public static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            return lheight > rheight ? lheight + 1 : rheight +1;
        }
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !check(s.charAt(left))) {
                left++;
            }
            while (left < right && !check(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean check(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
    //生成最长回文串的长度
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = countMap.get(c);
            if (count == null) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, count + 1);
            }
        }
        int len = 0;
        boolean oddFlag = false;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                len = len + entry.getValue();
            } else {
                len = len + entry.getValue() - 1;
                oddFlag = true;
            }
        }
        return oddFlag ? len + 1 : len;
    }
}
/*二分查找、深度优先、广度优先*/