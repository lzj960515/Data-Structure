package com.solution.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zijian Liao
 * @date 2020/5/23 0:17
 * @description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class TwoSum {

    public static void main(String[] args) {
        /*
        在茫茫人海中寻找一个可以相伴一生的真的好难，所以这就是有种职业叫做媒婆的原因吗？
        只要你告诉媒婆你要个什么样的女朋友，媒婆就可以帮你轻松找到。
        今日习题：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

        示例：给定 nums = [2, 11, 7, 15], target = 9
        因为 nums[0] + nums[2] = 2 + 7 = 9
        所以返回 [0, 2]

        解：在示例中，我们需要在数组中找到两个元素相加为9,可以将问题进行转化成媒婆问题，
        首先我们先取出一个元素2,然后我们在媒婆的姻缘册上查找有没有我们需要的对象9-2=7，
        此时媒婆的姻缘册上显然是什么都没有的，那么我们将自己(2)记录到媒婆的姻缘册上，等待媒婆分配。
        然后我们取出第二个元素11，询问媒婆，有没有俺的对象9-11=-2，
        此时姻缘上只含有元素[2],配对失败，将11记录在小本本上。
        我们继续取出第三个元素7，询问媒婆，有没有俺的对象9-7=2，媒婆发现姻缘册[2,11]上有耶，恭喜，牵手成功。
        如此，我们便将一个茫茫人海寻址你的超级难题，简单成了媒婆我有，女票到手的问题。
         */
        int[] nums = {2, 11, 7, 15};
        int[] ints = new TwoSum().twoSum(nums, 9);

    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer complement = map.get(target - nums[i]);
            if (complement != null) {
                return new int[] { complement, i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
