package com.jyx.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: jiangyexin
 * @Description:快速排序
 * 最坏时间复杂度：O(n2)
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 首先就地快速排序使用的空间是O(1)的，也就是个常数级；而真正消耗空间的就是递归调用了，因为每次递归就要保持一些数据；
最优的情况下空间复杂度为：O(logn)  ；每一次都平分数组的情况
最差的情况下空间复杂度为：O( n )      ；退化为冒泡排序的情况
 * 是否是稳定排序：否
 * @Date: 2018-08-22 10:41
 **/
public class QuickSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSorte(int[] arr, int left, int right) {
        int i,j,base,temp;
        if (left > right) {
            return;
        }
        base = arr[left];//base为基准数
        i = left;
        j = right;
        while(i != j) {
            //先从右边开始找小于基准数的数据。右边的哨兵先移动，这个顺序很重要
            while(arr[j] >= base && i < j) {
                j--;
            }
            //然后从左边开始找大于基准数的数据
            while(arr[i] <= base && i < j) {
                i++;
            }
            //交换两个数在数组中的位置
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //最终将基准数归位
        arr[left] = arr[i];
        arr[i] = base;
        quickSorte(arr, left, i - 1);
        quickSorte(arr, i + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {3,9,8,7,4,5,6,3};
        quickSorte(arr,0, arr.length -1);
        ArrayList arr1 = new ArrayList();

        Collections.synchronizedList(arr1);
        printArr(arr);
    }


    /*堆排序、归并排序*/
    /*二分查找、线性查找、深度搜索、广度搜索*/
}
