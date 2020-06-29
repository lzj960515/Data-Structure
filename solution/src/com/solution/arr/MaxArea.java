package com.solution.arr;

/**
 * @author Zijian Liao
 * @date 2020/5/21 13:49
 * @description 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int cur = height[i];
            for (int j = i + 1; j < length; j++) {
                int next = height[j];
                int size = 0;
                if (cur > next) {
                    size = next * (j - i);
                } else {
                    size = cur * (j - i);
                }
                max = max > size ? max : size;
            }
        }
        return max;
    }

    //代码实现
    public int maxAreaPro(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int size;
        while (i != j) {
            int left = height[i];
            int right = height[j];
            if (left < right) {
                size = left * (j - i);
                i++;
            } else {
                size = right * (j - i);
                j--;
            }
            max = max > size ? max : size;
        }
        return max;
    }

    public static void main(String[] args) {
        /*

        给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
        在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        输入：[1,8,6,2,5,4,8,3,7]
        输出：49
        8


        我们可以使用双指针法，从两端往中间靠拢的方式进行计算
        初始化最大盛水量 max=0
        1.取出两端元素，a1,an
        如果 a1<an, a1到an的长度为t=n-1,则容器盛水量为size1=(更短的元素)a1*t 此时max=size1;
        此时，我们将更短的一边（a1）往右移 -> a2  疑问：为什么是移动更短的一边的呢？
        如果 a2>an, a1到an的长度为t2=n-2, 则容器盛水量为size2=an*t2 若max<size2 则 max = size2;
        此时，我们将更短的一边（an）往左移 -> an-1
        如果两端高度相等，则任意移动一边，重复以上步骤，直到两边重合

        为什么是移动更短的一边?
        由于a1<an a1到an的距离为t 容器盛水量为 a1*t
        此时如果使an往左移动，则此时不管an-1>a1 或者 an-1<a1，容器的最高高度只能为a1
        而a1到an-1的距离t2<t1,所以容器盛水量为 an-1*t2<=a1*t2<a1*t1;
        所以我们应该移动更短的一边

        */
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = new MaxArea().maxAreaPro(height);
        System.out.println(i);
    }
}
