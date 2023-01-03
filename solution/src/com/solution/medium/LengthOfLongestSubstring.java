package com.solution.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        // 如何判断无重复？
        // hash 使用hashSet存储每一个字符，当出现重复字符时，记录此时长度，并且清除hashSet
        // dvdf 当出现重复字符时回到该字符处？no, 取该字符之间的长度，继续计算
        int max = 0;
        int len = 0;
        int cur = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer pre = map.get(c);
            // 空 或者 重复的位置是否在刻度之前
            if (pre == null || pre < cur) {
                len++;
            }else {
                // 重复 且在刻度之后
                max = Math.max(max, len);
                // 长度取两个重复字符之间的长度
                len = i - pre;
                // 刻度修改为重复字符之后
                cur = pre + 1;
            }
            map.put(c, i);
        }
        return Math.max(max, len);
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("dvdf"));
    }
}
