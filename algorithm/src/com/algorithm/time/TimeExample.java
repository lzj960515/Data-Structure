package com.algorithm.time;

/**
 * @author Zijian Liao
 * @date 2020/5/18 14:32
 * @description
 */
public class TimeExample {

    public static void main(String[] args) {
        //时间复杂度：执行一段程序所花费的时间
        //执行时间从小到大排序 O(1)<O(logn)<O(n)<O(nlogn)<O(n^2)<O(n^x)
        int a = 1; //O(1)
        for (int i = 0; i < 10; i++){ //执行11次  O(1) 执行次数小于1000 时间复杂度都为常量阶
            a = a + 1; //执行10次
        }

        int n = Integer.MAX_VALUE; //表示n为未知
        while(a < n){
            a = a * 2; //1 2 4 8 16 2^0 2^1 2^2 2^3 2^4 .... 2^x=n x=log2n 去除常数阶 -> logn O(logn)
        } //案例: 二分法

        for (int i = 0; i < n; i++) { //执行n+1次
            a = a + 1; //执行n次
        } //循环共执行 2n+1次 去除常数阶 O(n)


        for (int i = 0; i < n; i++) { //和以上两种情况相结合，时间复杂度为:O(nlogn)
            while(a < n){
                a = a * 2;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a = a + 1;  //共执行n^2次 案例冒泡排序时间复杂度也为 O(n^2)
            }
        }

    }
}
