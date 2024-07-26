package com.code.java.practise.package1;
import java.util.*;

/**
 * 这是k排列问题，深度递归，剪枝 超时了
 * 1234
 * 1324
 * 1342
 * 1423
 * 1432
 */
public class Question60 {
    public static void main(String[] args) {
        System.out.println(new Question60().getPermutation(9, 278621));
    }
    private List<String> result = new ArrayList<>();

    private Map<Integer, Boolean> nums = new HashMap<>();

    public String getPermutation(int n, int k) {
        for (int i = 0; i < n; i++) {
            nums.put(i + 1, false);
        }
        List<Integer> res = new LinkedList<>();
        dfs(nums, res, k);
        return result.get(k - 1);
    }

    private boolean dfs(Map<Integer, Boolean> nums, List<Integer> res, int k) {
        //终止条件
        if (res.size() == nums.size()) {
            result.add(listToString(res));
            if (result.size() == k) {
                return false;
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer element = Integer.valueOf(i + 1);
            Boolean isElementUsed = nums.get(element);
            if (!isElementUsed) {
                res.add(element);
                nums.put(element, true);
                if (dfs(nums, res, k)) {
                    res.remove(element);
                    nums.put(element, false);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private String listToString(List<Integer> num) {
        StringBuilder stringBuilder = new StringBuilder();
        num.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
