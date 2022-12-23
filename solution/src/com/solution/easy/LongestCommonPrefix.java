package com.solution.easy;


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix {
    
    public String solution(String[] strs){
        int j = 0;
        int length = strs[0].length();
        for (String str : strs) {
            if(length > str.length()){
                length = str.length();
            }
        }
        if (length == 0){
            return "";
        }
        while (true){
            if(j == length){
                return strs[0].substring(0, j);
            }
            char tmpC = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (tmpC != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
            j++;
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.solution(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix.solution(new String[]{""}));
        System.out.println(longestCommonPrefix.solution(new String[]{"a"}));
    }
}
