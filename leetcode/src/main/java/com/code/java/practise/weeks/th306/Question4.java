package com.code.java.practise.weeks.th306;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月14日-11:42:43
 * @apiNote: .
 */
public class Question4 {
    public static void main(String[] args) {
        Question4 question4 = new Question4();
        System.out.println(question4.countSpecialNumbers(30));
    }

    public int countSpecialNumbers(int n) {
		return countSpecialNumbers(0, 0, "" + n, new Integer[("" + n).length()][1 << 10]) - 1;
	}

	private int countSpecialNumbers(int index, int mask, String n, Integer[][] dp) {
		mask = mask < 2 ? 0 : mask;
		if (index == dp.length) {
			return 1;
		} else if (dp[index][mask] == null) {
			int count = (mask & 1 << n.charAt(index) - '0') > 0 ? 0
					: countSpecialNumbers(index + 1, mask | 1 << n.charAt(index) - '0', n, dp);
			for (int i = 0; i < n.charAt(index) - '0'; i++) {
				count += (mask & 1 << i) > 0 ? 0 : countSpecialNumbers(index + 1, mask | 1 << i, "9999999999", dp);
			}
			dp[index][mask] = n.equals("9999999999") ? count : null;
			return count;
		}
		return dp[index][mask];
	}
}
