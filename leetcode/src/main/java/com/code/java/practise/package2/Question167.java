package com.code.java.practise.package2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月07日 22:08:47
 * @apiNote:就像相亲一样，把自己的要求(key)，和自己的联系方式(value).放到相亲角,
 * 然后再次遍历数组中符合相亲角要求的数字，撮合一对就行了
 */
public class Question167 {
    public static void main(String[] args) {
        Question167 question167 = new Question167();
        int[] numbers = new int[] {-1,0};
        int target = -1;
        int[] twoSum = question167.twoSum(numbers, target);
        System.out.println("[" + twoSum[0] + "," + twoSum[1] + "]");
    }

    public int[] twoSum(int[] numbers, int target) {
        // 用于存放自己的角标和需要的另一半
        // key 需要的另一半，value 自己的角标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(target - numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i]) && map.get(numbers[i]) != i) {
                return new int[] { i + 1, map.get(numbers[i]) + 1 };
            }
        }
        return new int[2];
    }
}
