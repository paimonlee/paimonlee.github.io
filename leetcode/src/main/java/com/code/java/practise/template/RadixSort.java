package com.code.java.practise.template;

import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        List<Integer> nums = Arrays.asList(123, 34, 12, 6442, 341, 4, 23, 62);
        int radix = 100;
        System.out.println(radixSort.getK(12345, 2));
    }

    /**
     * 基数排序
     *
     * @param nums  需要排序的数组
     * @param radix 基数
     * @return 排序好的数组
     */
    public List<Integer> radixSort(List<Integer> nums, int radix) {
        List<Integer> result = new ArrayList<>();
        //找到最大的元素用于计算轮数
        int max = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i));
        }
        //计算需要计算的轮数
        int count = 0;
        while (max > 0) {
            count++;
            max /= radix;
        }
        int oldRadix = radix / 10;
        LinkedList<Integer> collector = null;
        for (int i = 0; i < count; i++) {
            LinkedList<Integer>[] bins = new LinkedList[radix];
            for (Integer num : nums) {
                int sortNumber = (num / oldRadix) % radix;
                LinkedList<Integer> bin = bins[sortNumber];
                if (Objects.isNull(bin)) {
                    bin = new LinkedList<>();
                }
                bin.add(num);
                bins[sortNumber] = bin;
            }
            collector = new LinkedList<>();
            for (LinkedList bin : bins) {
                if (Objects.nonNull(bin)) {
                    collector.addAll(bin);
                }
            }
            nums = collector;
            oldRadix = oldRadix * radix;
        }
        result.addAll(collector);
        return result;
    }

    /**
     * 获取一个十进制数字的第k位
     */
    private int getK(int num, int k) {

        int n = (int) Math.pow(10, k - 1);
        return (num / n) % 10;
    }
}
