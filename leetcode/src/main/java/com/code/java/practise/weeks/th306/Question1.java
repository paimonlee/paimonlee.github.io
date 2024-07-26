package com.code.java.practise.weeks.th306;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月14日-10:38:33
 * @apiNote: .
 */
public class Question1 {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 9, 9, 8, 1 }, { 5, 6, 2, 6 }, { 8, 2, 6, 4 }, { 6, 2, 2, 2 } };
        Question1 question1 = new Question1();
        int[][] largestLocal = question1.largestLocal(grid);
        for (int i = 0; i < largestLocal.length; i++) {
            for (int j = 0; j < largestLocal.length; j++) {
                System.out.print(largestLocal[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = findMax(i + 1, j + 1, grid);
            }
        }
        return maxLocal;
    }

    private int findMax(int heartX, int heartY, int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = heartX - 1; i <= heartX + 1; i++) {
            for (int j = heartY - 1; j <= heartY + 1; j++) {
                max = Math.max(grid[i][j], max);
            }
        }
        return max;
    }
}
