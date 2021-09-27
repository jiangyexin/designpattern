package com.jyx.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 括号问题
 * @author jiangyexin
 * @date 2021/8/13 11:34
 */
public class Brackets {

    public static void main(String[] args) {
        generateParenthesis(3);
    }

    /**
     * https://leetcode-cn.com/problems/generate-parentheses/
     * 括号生成-回溯法
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        search(0, 0, n, s, res);
        return res;
    }

    public static void search(int leftCount, int rightCount, int n, StringBuilder s,List<String> res) {
        if (leftCount == n && rightCount == n) {
            res.add(s.toString());
            return;
        }
        if (leftCount <= n) {
            s.append("(");
            search(leftCount + 1, rightCount, n, s, res);
            s.deleteCharAt(s.length() - 1);
        }
        if (leftCount > rightCount && rightCount <= n) {
            s.append(")");
            search(leftCount, rightCount + 1, n, s, res);
            s.deleteCharAt(s.length() - 1);
        }
    }

    /**
     * 验证括号有效
     * https://leetcode-cn.com/problems/valid-parentheses/
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && !check(s.charAt(i))) {
                return false;
            }
            if (check(s.charAt(i))) {
                leftCount++;
                stack.push(s.charAt(i));
            } else {
                rightCount++;
                char c;
                if (s.charAt(i) == '}') {
                    c = '{';
                } else if (s.charAt(i) == ']') {
                    c = '[';
                } else {
                    c = '(';
                }
                if (!stack.empty() && stack.peek() == c) {
                    stack.pop();
                }
            }
        }
        return leftCount == rightCount && stack.empty() ? true : false;
    }

    private boolean check(char c) {
        if (c == '{' || c == '[' || c == '(') {
            return true;
        } else {
            return false;
        }
    }
}
