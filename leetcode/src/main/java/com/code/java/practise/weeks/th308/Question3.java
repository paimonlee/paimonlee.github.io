package com.code.java.practise.weeks.th308;

import java.util.Arrays;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        Question3 question3 = new Question3();
        String[] garbage = new String[]{"G", "P", "GP", "GG"};
        int[] travel = new int[]{2, 4, 3};
        System.out.println(question3.garbageCollection(garbage, travel));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        List<String> garType = Arrays.asList("M", "G", "P");
        int result = 0;
        for (String g : garType) {
            int i = garbage.length - 1;
            for (; i >= 0; i--) {
                String garG = garbage[i];
                if (garG.contains(g)) {
                    break;
                }
            }
            for (int j = 0; j <= i; j++) {
                int count = 0;
                while (garbage[j].contains(g)) {
                    garbage[j] = garbage[j].replaceFirst(g, "");
                    count++;
                }
                result += count;
            }
            for (int j = 0; j < i; j++) {
                result += travel[j];
            }
        }
        return result;
    }
}
