package com.code.java.practise.template;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月24日 18:06:31
 * @apiNote: 二分查找模板
 */
public class BinarySearch {

    public int binarySearch(int start, int end, int[] ints, int target) {
        // 退出条件，找到或者未找到
        if (ints.length == 0) {
            // 空数组
            return -1;
        } else if (start == end) {
            // 开始角标等于末尾角标
        } else if (start > end) {
            // 开始角标大于末尾角标
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (ints[mid] == target) {
            // 判断中间这个值是不是想要的
            return mid;
        } else if (ints[mid] > target) {
            return binarySearch(start, mid - 1, ints, target);
        } else {
            return binarySearch(mid + 1, end, ints, target);
        }
    }
}
