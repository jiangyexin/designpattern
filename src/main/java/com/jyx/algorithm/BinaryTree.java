package com.jyx.algorithm;

import java.util.List;

/**
 * @author jiangyexin
 * @date 2021/8/9 16:40
 */
public class BinaryTree {
    class TreeNode<T> {
        private T value;
        private TreeNode left;
        private TreeNode right;
        TreeNode(T val) {
            value = val;
        }

    }

    /**
     * 翻转二叉树
     * @param root
     */
    public void invertTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
    }

    /**
     * 先序遍历
     * @param root
     * @param visitor
     */
    public void preOrder(TreeNode root, List visitor) {
        if (root == null) {
            return;
        }
        visitor.add(root.value);
        preOrder(root.left, visitor);
        preOrder(root.right, visitor);
    }

    public void mediumOrder(TreeNode root, List visitor) {
        if (root == null) {
            return;
        }
        mediumOrder(root.left,visitor);
        visitor.add(root.value);
        mediumOrder(root.right, visitor);
    }

    public void postOrder(TreeNode root, List visitor) {
        if (root == null) {
            return;
        }
        postOrder(root.left, visitor);
        postOrder(root.right, visitor);
        visitor.add(root.value);
    }

    /**
     * 根据先序遍历和中序遍历构建二叉树
     * @param preOrder
     * @param mediumOrder
     * @return
     */
    public TreeNode buildTree1(Object[] preOrder, Object[] mediumOrder) {
        return buildByPreAndMedium(preOrder, 0, preOrder.length - 1, mediumOrder, 0, mediumOrder.length - 1);
    }

    private TreeNode buildByPreAndMedium(Object[] preOrder, int preStart, int preEnd, Object[] mediumOrder, int mediumStart, int mediumEnd) {
        Object rootVal = preOrder[preStart];
        int index = 0;
        for (int i = mediumStart; i <= mediumEnd; i++) {
            if (mediumOrder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - mediumStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildByPreAndMedium(preOrder, preStart + 1, preStart + leftSize, mediumOrder, mediumStart, index - 1);
        root.right= buildByPreAndMedium(preOrder, preStart + leftSize + 1, preEnd, mediumOrder, index + 1, mediumEnd);;
        return root;
    }

    /**
     * 根据后序遍历和中序遍历构建二叉树
     * @param postOrder
     * @param mediumOrder
     * @return
     */
    public TreeNode buildTree2(Object[] postOrder, Object[] mediumOrder) {
        return buildByPostAndMedium(postOrder, 0, postOrder.length - 1, mediumOrder, 0, mediumOrder.length - 1);
    }

    private TreeNode buildByPostAndMedium(Object[] postOrder, int postStart, int postEnd, Object[] mediumOrder, int mediumStart, int mediumEnd) {
        Object rootVal = postOrder[postEnd];
        int index = 0;
        for (int i = mediumStart; i <= mediumEnd; i++) {
            if (mediumOrder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - mediumStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildByPostAndMedium(postOrder, postStart, postStart + leftSize - 1, mediumOrder, mediumStart, index - 1);
        root.right = buildByPostAndMedium(postOrder, postStart + leftSize, postEnd - 1, mediumOrder, index + 1, mediumEnd);
        return root;
    }

    /**
     * 构造最大二叉树
     * @param arrs
     * @return
     */
    public TreeNode buildMaxTree(Integer[] arrs) {
        return buildMax(arrs, 0, arrs.length - 1);
    }
    private TreeNode buildMax(Integer[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = -1,maxValue = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (arr[i] > maxValue) {
                index = i;
                maxValue = arr[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = buildMax(arr, start, index - 1);
        root.right = buildMax(arr, index + 1, end);
        return root;
    }
}
