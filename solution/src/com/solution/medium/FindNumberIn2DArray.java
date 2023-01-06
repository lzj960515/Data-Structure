package com.solution.medium;

/**
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target){
            return false;
        }
        // 从小到大z型遍历问题：需要看下一位的大小，如果下一位更大，则需要回退横坐标
        // 从大到小则没有这样的问题
        int y = 0;
        int x = matrix.length - 1, n = matrix[0].length;
        while (x >= 0 && y<n){
            int num = matrix[x][y];
            if(num == target){
                return true;
            }
            if(num > target){
                x--;
            }else {
                y++;
            }
        }
        return false;
    }


    // 这瞎写的居然也击败100%，说实话我自己也有点懵
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target){
                return false;
            }
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                if (matrix[i][i1] > target) {
                    break;
                }
                if (matrix[i][i1] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(matrix, 5));
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(matrix, 20));
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(new int[][]{{}}, 1));
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(new int[][]{{-1},{-1}}, -2));
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(new int[][]{{5},{6}}, 6));
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(new int[][]{{1},{3},{5}}, 2));
    }
}
