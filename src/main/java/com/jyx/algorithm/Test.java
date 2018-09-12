package com.jyx.algorithm;

import java.util.*;

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


        Queue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.offer(9);
        priorityQueue.offer(5);
        priorityQueue.offer(7);
        priorityQueue.offer(3);
        priorityQueue.offer(6);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
    public static Comparator<Integer> comparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return  o1 < o2 ? 1 : -1;
        }
    };

    /*二叉树遍历*/
    class Node {
        public Node left;
        public Node right;
    }
    public static List<Node> visitor = new ArrayList<Node>();
    public static void binScan(Node root) {
        while (root != null) {
            /*先序遍历 中左右*/
            visitor.add(root);
            binScan(root.left);
            binScan(root.right);

            /*中序遍历 左中右*/

            /*后序遍历 左右中*/
        }
    }
}
/*二分查找、深度优先、广度优先*/