package com.code.java.practise.package2;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月31日 17:09:05
 * @apiNote:
 */
public class Question134 {
    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        Question134 question134 = new Question134();
        int canCompleteCircuit = question134.canCompleteCircuit(gas, cost);
        System.out.println(canCompleteCircuit);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int allSum = 0, leftGas = 0, start = 0;
        for (int i = 0; i < gas.length; ++i) {
            leftGas += (gas[i] - cost[i]);
            allSum += (gas[i] - cost[i]);
            if (leftGas < 0) {
                //车辆在这一站无法到达下一站
                //所以应该在下一站起步
                start = i + 1;
                leftGas = 0;
            }
        }
        return allSum < 0 ? -1 : start;
    }
}
