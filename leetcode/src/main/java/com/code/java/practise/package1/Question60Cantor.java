package com.code.java.practise.package1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question60Cantor {
    public static void main(String[] args) {
        String permutation = new Question60Cantor().getPermutation(9, 278621);
        System.out.println(permutation);
    }

    public String getPermutation(int n, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        int[] factorial = new int[n + 1];
        ArrayList<Integer> nums = new ArrayList<>();
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(Integer.valueOf(i));
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        while (n > 0) {
            int numSort = (k) / factorial[n - 1];
            k = (k) % factorial[n - 1];
            Integer remove = nums.remove(numSort);
            stringBuffer.append(remove);
            n--;
        }
        return stringBuffer.toString();
    }
}
