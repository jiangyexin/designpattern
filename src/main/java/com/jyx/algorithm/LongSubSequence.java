package com.jyx.algorithm;

import java.util.HashMap;

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
        int[] arr4 = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};

        //System.out.println(longSubSeq1(arr1, 1));
        System.out.println(longSubSeq1(arr2, 1));
        System.out.println(longSubSeq1(arr3, -2));
        System.out.println(longSubSeq1(arr4, 0));
    }
    //初始方法
    public static int longSubSeq(int[] arr, int difference) {
        int result = 1;
        for (int i = 0; i < arr.length -1; i++) {
            int l = 1;
            int index = i;
            for (int j = index + 1; j < arr.length; j++) {
                if (arr[j] - arr[index] == difference) {
                    l++;
                    index = j;
                }
            }
            result = l > result ? l : result;
        }
        return result;
    }
    //优化1
    public static int longSubSeq1(int[] arr, int difference) {
        int result = 1;
        int[] cache = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int l = 1;
            int index = i;
            boolean flag = false;
            for (int j = index + 1; j < arr.length; j++) {
                //如果j位置算过了就直接返回
                if (arr[j] - arr[index] == difference) {
                    if (cache[j] != 0) {
                        flag = true;
                        l = l + cache[j];
                        break;
                    }
                    flag = true;
                    l++;
                    index = j;
                }
            }
            if (flag) {
                cache[i] = l;
            }
            result = l > result ? l : result;
        }
        return result;
    }


    public static int longSubSeq2(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;//最小返回1
        for (int length : arr) {
            //查看在这个数之前是否有length - difference这个数，有则返回，没有就是0，加一是要加上自己的长度
            int orDefault = map.getOrDefault(length - difference, 0)+1;
            //得到最大长度
            max = Math.max(max,orDefault);
            //将当前值存入
            map.put(length,orDefault);
        }
        return max;
    }
}
