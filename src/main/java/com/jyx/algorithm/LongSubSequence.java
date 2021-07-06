package com.jyx.algorithm;

/**
 * 最长等差子序列
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * @author jiangyexin
 * @date 2021/7/6 13:43
 */
public class LongSubSequence {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {1,3,5,7};
        int[] arr3 = {1,5,7,8,5,3,4,2,1};
        System.out.println(longSubSeq(arr1, 1));
        System.out.println(longSubSeq(arr2, 1));
        System.out.println(longSubSeq(arr3, -2));
    }

    public static int longSubSeq(int[] arr, int dif) {
        int result = 1;
        for (int i = 0; i < arr.length -1; i++) {
            int l = 1;
            int index = i;
            for (int j = index; j < arr.length; j++) {
                if (arr[j] - arr[index] == dif) {
                    l++;
                    index = j;
                }
            }
            result = l > result ? l : result;
        }
        return result;
    }
}
