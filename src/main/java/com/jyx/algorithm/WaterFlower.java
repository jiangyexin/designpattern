package com.jyx.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Q:水仙花数
 */
public class WaterFlower {
    public static void main(String[] args) {
        List result = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            int[] arr = intToArr(i);
            if (powSum(arr) == i) {
                result.add(i);
            }
        }

        System.out.println(result);

    }

    public static int[] intToArr(int a) {
        String numStr = String.valueOf(a);
        int[] arr = new int[numStr.length()];
        for (int i = 0; i < arr.length;i++) {
            arr[i] = Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }
        return arr;
    }

    public static int powSum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i] * arr[i] * arr[i];
        }
        return result;
    }
}
