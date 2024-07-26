package com.code.java.practise.package1;

import java.util.*;

public class Question84 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 2};
        int i = new Question84().largestRectangleArea(heights);
        System.out.println(i);
    }
//    public int largestRectangleArea(int[] heights) {
//        Deque<Integer> indexDeque = new LinkedList<>();
//        int n = heights.length;
//        int[] left = new int[n];
//        int[] right = new int[n];
//        Arrays.fill(right, n);
//        for (int i = 0; i < n; i++) {
//            //堆中保存的不为空，而且新进来的元素小于上一个元素
//            while(!indexDeque.isEmpty() && heights[indexDeque.peekFirst()]>heights[i]){
//                right[indexDeque.pollFirst()]=i;
//            }
//            left[i]=indexDeque.isEmpty()? -1:indexDeque.peekFirst();
//            indexDeque.addFirst(i);
//        }
//        int ans=0;
//        for (int i = 0; i < n; i++) {
//            ans= Math.max(ans,heights[i]*(right[i]-left[i]-1));
//        }
//        return ans;
//    }

    /**
     * [0,2,1,2,0]
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int[] newHeight = new int[heights.length + 2];
        for (int i = 1; i <= heights.length; i++) {
            newHeight[i] = heights[i - 1];
        }
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int height = newHeight[stack.pop()];
                ans = Math.max(ans, (i - stack.peek() - 1) * height);
            }
            stack.push(i);
        }
        return ans;
    }
}
