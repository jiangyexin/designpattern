package com.jyx.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO：还没有做对
 *3、将一个交错数组合并为一个一维数组
 * 输入: strJaggedArray[][], 由多个一维数组(长度不定,个数不定)组成的交错数组
 * 输出: strArray[], 由strJaggedArray[r][c]中的元素以"&"为分隔符拼合而成, 是strJaggedArray中数组元素的无重复组合(不考虑顺序)
 *
 * 举例:
 * 输入: strJaggedArray[0]=new string[] {"we","are","student"};
 *       strJaggedArray[1]=new string[] {"say","what"};
 * 输出: strArray[]={"we&say","we&what","are&say","are&what","student&say","student&what"}
 *
 * 输入: strJaggedArray[0]=new string[] {"cs","app"};
 *       strJaggedArray[1]=new string[] {"good","cool","dev"};
 *       strJaggedArray[2]=new string[] {"king","of","the","world"};
 * 输出: strArray[]={"cs&good&king","cs&good&of","cs&good&the","cs&good&world","cs&cool&king","cs&cool&of","cs&cool&the","cs&cool&world",...}
 * @author jiangyexin
 * @date 2021/9/9 15:14
 */
public class TencentInterviewJaggedArray {

    public static void main(String[] args) {
        String[][] strJaggedArray = {{"cs","app"},{"good","cool","dev"},{"king","of","the","world"}};
        List<String> strings = mergeSearch(strJaggedArray);
    }

    private static List<String> mergeSearch(String[][] strJaggedArray) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        search(strJaggedArray, 0, 0, sb, result);
        return result;
    }

    private static void search(String[][] strJaggedArray, int i, int j, StringBuilder sb, List<String> result) {
        if (i >= strJaggedArray.length || j >= strJaggedArray[i].length) {
            result.add(sb.delete(0,1).toString());
            return;
        }
        for (; i < strJaggedArray.length; i++) {
            for (; j < strJaggedArray[i].length; j++) {
                int len = strJaggedArray[i][j].length() + 1;
                sb.append("&").append(strJaggedArray[i][j]);
                search(strJaggedArray, i + 1, j, sb, result);
                sb.delete(sb.length() - len, sb.length());
            }
        }
    }
}
