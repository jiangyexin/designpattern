package com.jyx.algorithm.interview;

/**
 * @author jiangyexin
 * @date 2021/9/7 12:21
 */
public class NetEasyCodeInterviewQuickSort {

    public static void main(String[] args) {
        int[] a = {1,3,5,2,2};
        new NetEasyCodeInterviewQuickSort().findKth(a, 5, 3);
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        int result = 0;
        quickSort(a, 0, a.length - 1);
        int times = 0;
        for (int i = a.length - 1; i > 0; i--) {
            times++;
            if (times == K) {
                result = a[i];
            }
        }
        return result;
    }

    private void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int lp = left;
        int rp = right;
        int base = a[left];

        while (lp < rp) {
            while (lp < rp && a[rp] >= base) {
                rp--;
            }
            while (lp < rp && a[lp] <= base) {
                lp++;
            }
            if (lp < rp) {
                int tmp = a[lp];
                a[lp] = a[rp];
                a[rp] = tmp;
            }
        }

        a[left] = a[lp];
        a[lp] = base;
        quickSort(a, left, lp - 1);
        quickSort(a, lp + 1, right);
    }
}
