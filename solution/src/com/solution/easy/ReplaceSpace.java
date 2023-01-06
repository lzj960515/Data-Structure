package com.solution.easy;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @author Zijian Liao
 * @since 1.0.0
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        if(s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        int size = 0;
        for (char c : chars) {
            if (c == ' ') {
                size++;
            }
        }

        char[] result = new char[chars.length + size*2];
        size = 0;
        for (char c : chars) {
            if (c != ' ') {
                result[size++] = c;
            } else {
                result[size++] = '%';
                result[size++] = '2';
                result[size++] = '0';
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("We are happy."));
    }
}
