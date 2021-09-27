package com.jyx.algorithm;

/**
 * 接雨水问题
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author jiangyexin
 * @date 2021/8/13 10:08
 */
public class RainCollect {

    public static void main(String[] args) {

    }

    /**
     * 接雨水问题
     * 从第二个点到倒数第二个点，依次分别找到两遍最大值中的最小值，最小值减去当前位置的高度作为当前位置的储水量
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = i - 1;
            int right = i +1;
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;
            while (left >= 0) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }
                left--;
            }
            while (right < height.length) {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                right++;
            }
            int max = leftMax > rightMax ? rightMax : leftMax;
            if (max - height[i] < 0) {
                max = 0;
            } else {
                max = max - height[i];
            }
            count = count + max;
        }
        return count;
    }
}
