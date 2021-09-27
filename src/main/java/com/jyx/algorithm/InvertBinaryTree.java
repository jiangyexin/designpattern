package com.jyx.algorithm;

/**
 * 反转二叉树
 * @author jiangyexin
 * @date 2021/8/13 14:52
 */
public class InvertBinaryTree {

    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        TreeNode res = root;
        invert(root);
        return res;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invert(root.left);
        invert(root.right);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
