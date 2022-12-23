package com.solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 * 1 -> 2 -> 3
 *           ↓
 * 4 -> 5    6
 * ↑         ↓
 * 7 ←  8  ← 9
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int max = matrix[0].length * matrix.length;
        // 0:right 1:down 2:left 3:up
        int turn = 0, row = 0, col = 0;
        int rowEnd = matrix.length-1, colEnd = matrix[0].length-1;
        int rowStart = 1, colStart = 0;
        for (int i = 1; i <= max; i++) {
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
            result.add(matrix[row][col]);
            switch (turn){
                case 0: col++; break;
                case 1: row++; break;
                case 2: col--; break;
                case 3: row--; break;
                default:  break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.spiralOrder(new int[][]{{3},{2}}));
        System.out.println(spiralOrder.spiralOrder(new int[][]{{1,2,3},{4,5,6}, {7,8,9}}));
    }
}
