package com.solution.arr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Zijian Liao
 * @date 2020/5/22 11:12
 * @description 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],[-1, -1, 2]
 *
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class TreeSum {

    public List<List<Integer>> threeSum2(int[] nums) {
        //取出一个数组元素ai 计算数组其他元素的和是否为 0-ai
        //若找到，则将数组元素ai 以及其他两个元素放入结果集中
        //继续执行，直到数组遍历完毕
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            int target = -nums[i];
            List<Integer> set = new ArrayList<>();
            o:
            for (int j = i + 1; j < length; j++) {
                if (set.contains(target - nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(target - nums[j]);
                    list.add(nums[j]);
                    for (List<Integer> integers : result) {
                        if (isSame(integers, list)) {
                            continue o;
                        }
                    }
                    result.add(list);
                }
                set.add(nums[j]);
            }
        }
        return result;
    }

    public boolean isSame(List<Integer> list1, List<Integer> list2) {
        List<Integer> a = new ArrayList<>(list1);
        List<Integer> b = new ArrayList<>(list2);
        k:
        for (int k = 0; k < a.size(); ) {
            for (int i = 0; i < a.size(); i++) {
                int j = b.indexOf(a.get(i));
                if (j != -1) {
                    b.remove(j);
                    a.remove(i);
                    continue k;
                }
            }
            k++;
        }
        return a.isEmpty() && b.isEmpty();
    }

    public static void main(String[] args) {
        /*
        昨天我们用两个人的思路解决人两个数之和的问题，今天我们要解决三个数之和的问题，所以我们就用多人..咳咳，我说的其实是王者荣耀
        题目：你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
        如：给定数组 nums = [-1, 0, 1, 2, -1, -4]，满足要求的三元组集合为：[-1, 0, 1],[-1, -1, 2]

        解题思路：假设我(a)现在要来把王者，需要找两个差不多的队友(b,c)
        然后我现在有一份好友名单，我既不想找一个太菜的被坑，也不想找一个大神提高段位而增加游戏难度。
        于是，我把这份名单按菜鸡到大神（从左到右）的顺序排列，假设我也在名单里，我先把自己拿出来，然后选队友
        开始时，我把选个最菜（最左）的菜鸡，和一个最强（最右）的大神，然后估算一下我们的综合实力（a+b+c）
        我发现综合实力太菜（a+b+c<0),于是我稍稍选个没那么菜（左边往右移一位）的菜鸡，再次估算实力
        我又发现综合实力太强（a+b+c>0)，我只好放弃太过粗壮的大腿，选个没那么粗的（右边往左移一位），再次估算实力
        这是我发现综合实力刚刚好（a+b+c=0),开心，于是我把我自己和这两人记录下来，继续看还有没有适合的。
        直到所有人都选了一遍。
        然后，我再换个头（别问我为啥能换头），继续以上操作，直到把头都换了一遍，那么这份名单就选完啦。

         */
        System.out.println(10>>>1);

        int[] nums = {-1, 0, 1, 2, -1, -1, -1, -1, -4};
        List<List<Integer>> lists = new TreeSum().threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int diff = nums[i] + nums[l] + nums[r];
                if (diff == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++; r--;
                }
                else if (diff > 0) r--;
                else l++;
            }
        }
        return result;
    }

//    public List<List<Integer>> twoSum3(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        int len = nums.length;
//        if (len < 3) return ans;
//        Arrays.sort(nums); // 排序
//        for (int i = 0; i < len; i++) {
//            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
//            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
//            int L = i + 1;
//            int R = len - 1;
//            while (L < R) {
//                int sum = nums[i] + nums[L] + nums[R];
//                if (sum == 0) {
//                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
//                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
//                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
//                    L++;
//                    R--;
//                } else if (sum < 0) L++;
//                else R--;
//            }
//        }
//        return ans;
//    }
}
