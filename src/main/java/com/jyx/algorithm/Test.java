package com.jyx.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-22 13:55
 **/
public class Test {
    public static void main(String[] args) {
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
    }
}
