package com.jyx.algorithm.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangyexin
 * @date 2021/8/30 20:01
 */
public class AliCodeInterview {

    public static void main(String[] args) {

    }

    /**
     * Q1：最长回文字符串
     * @param s
     * @return
     */
    public String maxPalindromeSubstring(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (s.length() < 2) {
            return String.valueOf(s.charAt(0));
        }

        //回文为奇数长度
        int max = Integer.MIN_VALUE;
        int middle = -1;
        for (int i = 1; i < s.length(); i++) {
            int iMax = 1;
            //左右指针
            int left = i - 1;
            int right = i +1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                iMax = iMax + 2;
            }
            if (iMax > max) {
                max = iMax;
                middle = i;
            }
        }
        //回文为偶数长度
        int doubleMax = Integer.MIN_VALUE;
        int doubleMiddle = -1;
        for (int i = 1; i < s.length(); i++) {
            int iMax = 2;
            //左右指针
            int left = i - 1;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                iMax = iMax + 2;
            }
            if (iMax > doubleMax) {
                doubleMax = iMax;
                doubleMiddle = i;
            }
        }
        if (doubleMax > max) {//最长回文为偶数
            //根据中点以及回文长度截取字符串
            return s.substring(doubleMiddle - (doubleMax/2), doubleMiddle + (doubleMax/2));
        } else {//最长回文为奇数
            if (max == Integer.MIN_VALUE) {//
                return s.substring(0,1);
            }
            //根据中点以及回文长度截取字符串
            return s.substring(middle - ((max - 1)/2), middle + ((max - 1)/2) + 1);
        }
    }

    /**
     * Q2：验证ip地址有效
     * @param IP
     * @return
     */
    public boolean validIPAddress(String IP) {
        if (IP.indexOf(".") != -1) {
            return validIPAddressV4(IP);
        } else if (IP.indexOf(":") != -1) {
            return validIPAddressV6(IP);
        } else {
            return false;
        }
    }

    private boolean validIPAddressV4(String IP) {
        String[] ips = IP.split("\\.");
        if (ips.length != 4) {
            return false;
        }

        for (String s : ips) {
            int value = -1;
            try {
                value = Integer.parseInt(s);
            } catch (Exception e) {
                return false;
            }
            if (!(value >= 0 || value <= 255)) {
                return false;
            }
        }
        return true;
    }

    private boolean validIPAddressV6(String IP) {
        String[] ips = IP.split(":");
        if (ips.length != 8) {
            return false;
        }

        for (String s : ips) {
            //ipv6的格式校验
        }
        return true;
    }

    /**
     * Q3：去掉区间覆盖
     * 例子：{{2,4},{2,5},{1,7}}
     * 返回：1
     * @param linePart
     * @return
     */
    public int removeDupRange(int[][] linePart) {
        Set<Integer> delSet = new HashSet<>();
        for (int i = 0; i < linePart.length; i++) {
            int[] arri = linePart[i];
            for (int j = 0; j < linePart.length; j++) {
                int[] arrj = linePart[j];
                if (j != i) {
                    if (arri[0] >= arrj[0] && arri[1] <= arrj[1]) {
                        //被覆盖的区间记录，用set防止重复记录
                        delSet.add(i);
                    }
                }
            }
        }
        return linePart.length - delSet.size();
    }
}
