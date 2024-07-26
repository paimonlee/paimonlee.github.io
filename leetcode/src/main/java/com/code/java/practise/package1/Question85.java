package com.code.java.practise.package1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大矩形问题，又名孤岛问题,
 * 使用动态规划
 */
public class Question85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int i = new Question85().maximalRectangle(matrix);
        System.out.println(i);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            //遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> indexDeque = new LinkedList<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            //堆中保存的不为空，而且新进来的元素小于上一个元素
            while(!indexDeque.isEmpty() && heights[indexDeque.peekFirst()]>heights[i]){
                right[indexDeque.pollFirst()]=i;
            }
            left[i]=indexDeque.isEmpty()? -1:indexDeque.peekFirst();
            indexDeque.addFirst(i);
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans= Math.max(ans,heights[i]*(right[i]-left[i]-1));
        }
        return ans;
    }
}
