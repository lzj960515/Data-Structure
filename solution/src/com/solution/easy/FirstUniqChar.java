package com.solution.easy;

import java.util.*;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *
 */
public class FirstUniqChar {
    // 题解上的 击败100% 耗时1ms，像是专门为了解题写的，属实牛逼
    public char firstUniqChar(String s) {
        char ch = ' ';
        if (s == null || s.length() == 0) {
            return ch;
        }
        if (s.length() >= 26) {
            int min = s.length();
            for (char i = 'a'; i <= 'z'; i++) {
                int index = s.indexOf(i);
                if (index != -1 && index == s.lastIndexOf(i)) {
                    if (index < min) {
                        min = index;
                        ch = i;
                    }
                }
            }
            return ch;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (s.indexOf(c) == s.lastIndexOf(c)) {
                    return c;
                }
            }
            return ch;
        }
    }

    // 击败99.47%， 居然不是100%
    public char firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (char c : chars) {
            count[c - 97]++;
        }
        for (char c : chars){
            if(count[c - 97] == 1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'z');
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("dbddaadbb"));
        System.out.println(firstUniqChar.firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar.firstUniqChar("leetcode"));
    }
}
