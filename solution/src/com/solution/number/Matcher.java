package com.solution.number;

public class Matcher {


    public static void main(String[] args) {
        Matcher matcher = new Matcher();
//        System.out.println(matcher.isMatch("aaa", "aaa"));
//        System.out.println(matcher.isMatch("aaa", "a*"));
//        System.out.println(matcher.isMatch("aab", "a.*"));
//        System.out.println(matcher.isMatch("aab", "a*b"));
//        System.out.println(matcher.isMatch("aab", "a.."));
//        System.out.println(matcher.isMatch("aaa", "ab*a*c*a"));
//        System.out.println(matcher.isMatch("aaa", "aaaa"));
        System.out.println(matcher.isMatch("mississippi", "mis*is*ip*."));
        System.out.println(matcher.isMatch("ab", ".*c"));
    }

    public boolean isMatch(String s, String p){
        // 动态规划
        int i = 0, j = 0;
        boolean match = false;
        while (j < p.length() && i < s.length()){
            char c = s.charAt(i);
            char matchC = p.charAt(j);
            if(c == matchC){
                match = true;
                i++;j++;
                continue;
            }
            if(match && matchC == '*'){
                char preC = s.charAt(i - 1);
                while (i < s.length() && s.charAt(i) == preC){
                    i++;
                }
                j++;
                while (j < p.length() && p.charAt(j) == preC){
                    j++;
                }
                continue;
            }
            if(matchC == '.'){
                match = true;
                // 如果后面是个*，则快进到*后面的字符
                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
                    // *是最后一位，直接返回true
                    if(j + 1 == p.length() - 1){
                        return true;
                    }
                    // 快进到*后面的字符
                    j = j+2;
                    char nextC = p.charAt(j);
                    i++;
                    while(i < s.length()){
                        if(s.charAt(i) != nextC){
                            i++;
                        }
                    }
                    // s字符串匹配完毕，判断p字符串是否为 x
                    if(i == s.length()){
                        if(j + 1 == p.length()){
                            return true;
                        }
                        // 判断后续的字符串也要匹配nextC, 不匹配则失败
                        return true;
                    }
                    i++;
                    continue;
                }
                // 后面不是*，不管
                i++; j++;
                continue;
            }
            // 啥也不是，重新开始匹配
            match = false; i = 0; j++;
        }
        return i == s.length() && (j == p.length() || (p.charAt(j) == '*' || p.charAt(j-1) == '*' || p.charAt(j-1) == '.'));
    }

    public boolean isMatch2(String s, String p) {
        // 双指针
        // 第一个指针指向s的字符
        // 第二个指针指向p的字符
        // 从第一个字符开始，判断两个指针指向的字符是否相等
        // 如果不相等
        // 1、p指针是否指向.
        // 2、p指针是否指向*
        //   2.1、如果是指向*，判断前一个字符是否为. 为.直接返回true
        //   2.2、如果不是. 则p指针不动，s指针往后移动,直到遇到不同的字符
        // 如果相等，则s|p指针都往后移动
        int i = 0;
        int j = 0;

        o:while (i < p.length()) {
            if(j == s.length()){
                return false;
            }
            char c = p.charAt(i);
            while (j < s.length()) {
                char c1 = s.charAt(j);
                if(c == c1 || c == '.'){
                    i++;j++;
                    continue o;
                }
                if(c == '*'){
                    // 前一个是.  并且*是最后一个
                    if(p.charAt(i - 1) == '.' && i == p.length() - 1){
                        return true;
                        // 或者前两个字符相等
                    }else if(p.charAt(i - 1) == '.'){
                        // 前一个是. *不是最后一个
                        // 此时需要找到*后面字符在s字符串的位置
                        char c2 = p.charAt(i + 1);

                        while (j < s.length() && s.charAt(j) != c2){
                            j++;
                        }
                        if(j == s.length()){
                            // 说明到结束都没有找到
                            return false;
                        }
                        // 已找到s字符串中的c2,跳过这个相等的字符继续匹配
                        i++; i++; j++;
                        continue o;

                    }

                    else if(j>0 && p.charAt(i-1) == s.charAt(j-1)) {
                        // 继续循环，直到s字符串不等
                        j++;
                        while (j< s.length() && s.charAt(j) == c1){
                            j++;
                        }
                        // 并且去除到*后面与之相等的c1
                        i++;
                        while (i < p.length() && p.charAt(i) == c1){
                            i++;
                        }
                        continue o;
                    }
                }
                i++;
                continue o;
            }
        }
        return j == s.length();
    }
}
