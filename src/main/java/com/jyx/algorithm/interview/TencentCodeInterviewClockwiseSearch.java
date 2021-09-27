package com.jyx.algorithm.interview;

/**
 * 题目：顺时针遍历二维数组
 * @author jiangyexin
 * @date 2021/9/7 19:43
 */
public class TencentCodeInterviewClockwiseSearch {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{10,11,12,13},{14,15,16,17}};
        new TencentCodeInterviewClockwiseSearch().search(arr, 0, 3, 0, 3);
    }

    public void search(int[][] arr, int xMin, int xMax, int yMin, int yMax) {
        if (xMin > xMax || yMin > yMax) {
            return;
        }
        int iMin = xMin;
        int jMin = yMin;
        //上边
        while (iMin < xMax) {
            System.out.println(arr[jMin][iMin]);
            iMin++;
        }
        //右边
        while (jMin < yMax) {
            System.out.println(arr[jMin][iMin]);
            jMin++;
        }
        //下边
        while (iMin > xMin) {
            System.out.println(arr[jMin][iMin]);
            iMin--;
        }
        //左边
        while (jMin > yMin) {
            System.out.println(arr[jMin][iMin]);
            jMin--;
        }
        search(arr, xMin + 1, xMax - 1, yMin + 1, yMax -1);
    }
}
