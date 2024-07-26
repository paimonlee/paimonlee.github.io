package com.code.java.practise.weeks.th307;

/**
 * @author: liyunfeng@fiberhome.com
 * @since: 2022年8月21日-10:26:07
 * @apiNote: .
 */
public class Question1 {
    public static void main(String[] args) {
        Question1 question1 = new Question1();
        int[] energy = new int[] { 1, 4, 3, 2 };
        int[] experience = new int[] { 2, 6, 3, 1 };
        System.out.println(question1.minNumberOfHours(5, 3, energy, experience));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int result = 0;
        int sumEnergy = 0;
        for (int i : energy) {
            sumEnergy += i;
        }
        result += sumEnergy >= initialEnergy ? sumEnergy - initialEnergy + 1 : 0;
        for (int i : experience) {
            if (initialExperience <= i) {
                result += (i - initialExperience + 1);
                initialExperience += ((i - initialExperience + 1) + i);
            } else {
                initialExperience += i;
            }
        }
        return result;
    }
}
