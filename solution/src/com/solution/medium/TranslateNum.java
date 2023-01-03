package com.solution.medium;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum {

    public int translateNum(int num) {
        // 12258
        // 1->b 2->c 5->f 8->i
        // 1->b 22->w 5->f 8->i
        // 1->b 2->c 25->z 8->i
        // 1 2 2 5 8 | 1 22 5 8 | 1 2 25 8
        // 12 2 5 8 | 12 25 8
        // 58 -> 5 8
        // 258 -> 2 5 8 | 25 8
        // 2258 -> 2 2 5 8 | 2 25 8 | 22 5 8
        // 12258 -> 1 2 2 5 8 | 1 2 25 8 | 1 22 5 8 | 12 2 5 8 | 12 25 8
        // fn = f(n-1) + f(n-2) x
        // 32258 -> 2 2 2 5 8 | 2 2 25 8 | 2 22 5 8 | 32 2 5 8 x  | 32 25 8 x
        // n*10 + (n-1) > 25 fn = f(n-1)
        // n*10 + (n-1) <= 25 fn = f(n-1) + f(n-2)
        String s = String.valueOf(num);
        if(s.length() == 1) return 1;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        dp[0] = 1;
        dp[1] = 1;
        int a = num - (num / 100) * 100;
        if(a <= 25 && a >= 10){
            dp[1] = 2;
        }
        int i = 2;
        int pre = Integer.parseInt(String.valueOf(chars[chars.length -2]));
        for (int j = chars.length - 3; j >= 0; j--) {
            int n = Integer.parseInt(String.valueOf(chars[j]));
            int b = n*10 + pre;
            if(b <= 25 && b >= 10){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i -1];
            }
            pre = n;
            i++;
        }
        return dp[dp.length -1];
    }

    public int translateNum2(int num){
        // 写法2, 递归
        // 先计算最后两个
        int value = num % 100;
        int res = 1;
        if(value >= 10 && value <= 25){
            res = 2;
        }
        return translateNum(num/100, value/10, 1, res);
    }

    private int translateNum(int num, int preN ,int pre, int res){
        if(num <= 0){
            return res;
        }
        int n = num%10;
        int value = n*10 + preN;
        if(value >= 10 && value <= 25){
            return translateNum(num/10, n, res, pre+res);
        }else {
            return translateNum(num/10, n, res, res);
        }
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum2(25));
        System.out.println(translateNum.translateNum2(12258));
        System.out.println(translateNum.translateNum2(419605557));
    }

}
