package com.jyx.algorithm;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-23 10:05
 **/
public class HalfFind {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int findIndex = halfFind(arr, 5);
        System.out.println(findIndex);
    }

    public static int halfFind(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high)/2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
