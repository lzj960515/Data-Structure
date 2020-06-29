package com.solution;

/**
 * @author Zijian Liao
 * @date 2020/5/18 15:18
 * @description 给一个数，判断该数是否为2的n次方
 */
public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(is2Power(32));
        System.out.println(is2PowerPlus(32));
    }
    public static boolean is2Power(int num) {
        //常规解法
        while (num > 1) {
            if (num % 2 != 0) return false;
            num = num / 2;
        }
        return true;
    }

    public static boolean is2PowerPlus(int num){
        //进阶解法
        /*
        转为二进制               与运算
        2 -> 0010  1 -> 0001  2&1 0000
        4 -> 0100  3 -> 0011  4&3 0000
        8 -> 1000  7 -> 0111  8&7 0000
        16 -> 0001 0000  15 -> 0000 1111  16&15 0000 0000
        */
        return (num&(num-1)) == 0;
    }
}
