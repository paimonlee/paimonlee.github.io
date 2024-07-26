package com.code.java.practise.weeks.th309;

public class Question1 {
    public static void main(String[] args) {
        Question1 question1 = new Question1();
        String s = "zz";
        int[] distance = new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(question1.checkDistances(s, distance));
    }

    public boolean checkDistances(String s, int[] distance) {
        int length = s.length();
        int[] judge = new int[26];
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i) - 'a';
            int another = i + distance[index] + 1;
            if (judge[index] == 1) {
                continue;
            }
            if (another < s.length() && s.charAt(i) == s.charAt(another)) {
                judge[index] = 1;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
