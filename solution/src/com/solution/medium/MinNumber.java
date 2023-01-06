package com.solution.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 把数组排成最小的数
 * 
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinNumber {
    // todo 解题失败
    public String minNumber(int[] nums) {
        init(nums);
        StringBuilder sb = new StringBuilder();
        Integer minNumber = getMinNumber();
        while (minNumber != null){
            sb.append(minNumber);
            minNumber = getMinNumber();
        }
        priorityQueue.clear();
        map.clear();
        return sb.toString();
    }

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    private Map<Integer, List<Integer>> map = new HashMap<>();

    private void init(int[] nums){
        for (int num : nums) {
            int tmp = num;
            // 取到第一位
            while (num >= 10){
                num = num/10;
            }
            List<Integer> list = map.computeIfAbsent(num, (key) -> new ArrayList<>());
            list.add(tmp);
        }
        priorityQueue.addAll(map.keySet());
    }

    private Integer getMinNumber(){
        Integer f = priorityQueue.peek();
        List<Integer> list = map.get(f);
        if(list.isEmpty()){
            priorityQueue.poll();
            if(priorityQueue.isEmpty()){
                return null;
            }
            f = priorityQueue.peek();
            list = map.get(f);
        }
        if(list.size() == 1){
            Integer num = list.get(0);
            list.clear();
            return num;
        }

        // 首位都相同
        // 比较第二位 没有第二位，则比较首位
        // 第二位相同，比较第三位，没有第三位，则比较首位
        // 重复如此，找到最小的数
        List<Integer> tmp = new ArrayList<>(list);
        int a = 100; // 乘以10的次数
        while (tmp.size() > 1){
            // 判断tmp中的数字是否都相同
            int m = tmp.get(0);
            boolean flag = true;
            for (Integer integer : tmp) {
                if (m != integer) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
            // 如果所有数比a/100还小，说明此时进入了12 121情况,返回最大的数即可
            boolean maxFlag = true;
            for (Integer integer : tmp) {
                if(integer > a/100){
                    maxFlag = false;
                    break;
                }
            }
            if(maxFlag){
                int maxN = m;
                for (Integer integer : tmp) {
                    maxN = Math.max(maxN, integer);
                }
                tmp.clear();
                tmp.add(maxN);
            }
            // 找到最小的第二位
            int mins = Integer.MAX_VALUE;
            for (Integer num : tmp) {
                // 如果数字本身就小于a,则取首位
                if(num < a/10){
                    mins = Math.min(mins, f);
                    continue;
                }
                while (num >= a){
                    num = num/10;
                }
                mins = Math.min(mins, num%10);
            }
            // 保存相同第二位的数
            List<Integer> tmp2 = new ArrayList<>();
            for (Integer num : tmp) {
                // 如果数字本身就小于a,则取首位
                if(num < a/10){
                    if(mins == f){
                        tmp2.add(num);
                    }
                    continue;
                }
                int n = num;
                while (num >= a){
                    num = num/10;
                }
                if(num%10 == mins){
                    tmp2.add(n);
                }
            }
            // 继续循环
            tmp.clear();
            tmp.addAll(tmp2);
            a = a*10;
        }
        Integer integer = tmp.get(0);
        list.remove(integer);
        return integer;
    }

    public static void main(String[] args) {
        MinNumber minNumber = new MinNumber();
        System.out.println(minNumber.minNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
        System.out.println(minNumber.minNumber(new int[]{10,2}));
        System.out.println(minNumber.minNumber(new int[]{3,30,34,5,9}));
        // 121 12  < 12 121
        // 131 13  < 13 131
        // 139 13  > 13 139
        System.out.println(minNumber.minNumber(new int[]{121,12}));
        //[824,938,1399,5607,6973,5703,9609,4398,8247]
        //"13994398560757036973 824 8247 9389609"
        //"1399439856075703697382478249389609"
        //"1399439856075703697382478249389609"
    }

}
