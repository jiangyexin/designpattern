package com.jyx.algorithm.interview;

import java.util.ArrayList;
import java.util.Stack;

/**双栈排序
 * https://www.nowcoder.com/questionTerminal/d0d0cddc1489476da6b782a6301e7dec
 * @author jiangyexin
 * @date 2021/9/3 20:15
 */
public class MiCodeInterviewTwoStackSort {

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,4,5};
        new MiCodeInterviewTwoStackSort().twoStacksSort(arr);
    }
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        for (int e : numbers) {
            s1.push(e);
        }
        for (int i = 0; i < numbers.length; i++) {
            int min = Integer.MAX_VALUE;
            while (!s1.isEmpty()) {
                int val = s1.pop();
                if (val < min) {
                    min = val;
                }
                s2.push(val);
            }
            boolean flag = false;
            while (s2.size() > i) {
                int val = s2.pop();
                if (flag || val != min) {
                    s1.push(val);
                } else {
                    flag = true;
                }
            }
            s2.push(min);
        }
        ArrayList<Integer> result = new ArrayList();
        while (!s2.isEmpty()) {
            result.add(s2.pop());
        }
        return result;
    }
}
