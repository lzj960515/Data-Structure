package com.solution.medium;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * <p>
 * 1 -> 2 -> 3
 * ↓
 * 8 -> 9    4
 * ↑         ↓
 * 7 ←  6  ← 5
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：
 * <p>
 * 1 <= n <= 20
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 0:right 1:down 2:left 3:up
        int turn = 0, row = 0, col = 0;
        int rowEnd = n-1, colEnd = rowEnd;
        int rowStart = 1, colStart = 0;
        for (int i = 1; i <= n * n; i++) {
            result[row][col] = i;
            switch (turn){
                case 0: col++; break;
                case 1: row++; break;
                case 2: col--; break;
                case 3: row--; break;
                default:  break;
            }
            // now is right and col is end, so we should turn down
            if (turn == 0 && col == colEnd) {
                turn = 1;
                colEnd--;
            }
            // now is down and row is end, so we should turn left
            if (turn == 1 && row == rowEnd) {
                turn = 2;
                rowEnd--;
            }
            // now is left and col is start, so we should turn up
            if (turn == 2 && col == colStart) {
                turn = 3;
                colStart++;
            }
            // now is up and row is start, so we should turn right
            if (turn == 3 && row == rowStart) {
                turn = 0;
                rowStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        System.out.println(Arrays.deepToString(generateMatrix.generateMatrix(3)));;
    }

}
