package com.jyx.algorithm;

import java.util.*;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-23 14:25
 **/
public class TreeSearch {
    class TreeNode {
        public TreeNode[] childs;
    }
    public static List<TreeNode> visit = new ArrayList<TreeNode>();

    public static void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            visit.add(temp);
            for (int i = 0; i < temp.childs.length; i++) {
                queue.offer(temp.childs[i]);
            }
        }
    }
    public static void DFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            visit.add(temp);
            for (int i = 0; i < temp.childs.length; i++) {
                stack.push(temp.childs[i]);
            }
        }
    }

    public static void main(String[] args) {

    }
}






