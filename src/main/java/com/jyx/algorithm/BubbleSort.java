package com.jyx.algorithm;

/**
 * @author: jiangyexin
 * @Description:冒泡排序
 * 最坏时间复杂度：O(n2)
 * 平均时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 是否是稳定排序：是
 * @Date: 2018-08-22 9:39
 **/
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for(int i =0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {3,9,8,7,4,5,6,3};
        bubbleSort(arr);
        PrintArr.printArr(arr);
    }

}
