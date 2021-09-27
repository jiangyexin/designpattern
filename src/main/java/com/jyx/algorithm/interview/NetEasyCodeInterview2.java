package com.jyx.algorithm.interview;

/**
 * 题意：字符串去掉多余空格，并且单词首字母大写
 * @author jiangyexin
 * @date 2021/9/13 14:38
 */
public class NetEasyCodeInterview2 {
    public static void main(String[] args) {
        String s = "hello   world   jyx";
        char[] words = s.toCharArray();
        System.out.println(new NetEasyCodeInterview2().processWords(words));
    }

    private String processWords(char[] words) {
        int count = 0;
        for  (int i = 0; i < words.length; i++) {
            if (words[i] == ' ') {
                int j = i + 1;
                for (; j < words.length; j++) {
                    if (words[j] != ' ') {
                        break;
                    }
                    count++;
                }
                if (j != i + 1) {
                    int len = j - i - 1;
                    for (int p = j; p < words.length; p++) {
                        words[p - len] = words[p];
                    }
                }
                //TODO:转大写
            }

        }
        String result = new String(words);
        result = result.substring(0, result.length() - count);
        return result;
    }
}
