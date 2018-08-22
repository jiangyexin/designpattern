package com.jyx.algorithm;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:给定一个乱序的数组，找到每个元素对应的右边第一个比它大的元素的值
 * 使用栈
 * User: jiangyexin
 * Date: 2018-08-22
 * Time: 23:19
 */
public class FindMax {
    public static void main(String[] args) {
        int[] arr = {9,3,2,7,11,13};
        int[] res = {0,0,0,0,0,0};
        findMax(arr,res);
        PrintArr.printArr(res);
    }

    public static void findMax(int[] arr, int[] res) {
        Stack<Integer> stack = new Stack();
        int i = 0;
        while (i < arr.length) {
            if (stack.empty() || arr[stack.peek()] > arr[i]) {
                stack.push(i);
                i++;
            } else {
                res[stack.peek()] = arr[i];
                stack.pop();
            }
        }
    }
}
