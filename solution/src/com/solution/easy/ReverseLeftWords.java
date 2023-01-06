package com.solution.easy;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * @author Zijian Liao
 * @since 1.0.0
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        if (s.length() == 0 || n == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        System.arraycopy(chars, 0, result, chars.length - n, n);
        System.arraycopy(chars, n, result, 0, chars.length -n);
        return new String(result);
    }

    public String reverseLeftWords2(String s, int n) {
        if (s.length() == 0 || n == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (i < n) {
                result[chars.length - n + i] = chars[i];
            } else {
                result[i - n] = chars[i];
            }
        }
        return new String(result);
    }

    public String reverseLeftWords1(String s, int n) {
        if (s.length() == 0 || n == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i < n) {
                sb.append(chars[i]);
            }else {
                sb2.append(chars[i]);
            }
        }
        sb2.append(sb);
        return sb2.toString();
    }

    public static void main(String[] args) {
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        System.out.println(reverseLeftWords.reverseLeftWords("abcdefg", 2));
    }
}
